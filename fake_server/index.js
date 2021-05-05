const { ApolloGateway, RemoteGraphQLDataSource } = require("@apollo/gateway");
const { ApolloServer } = require("apollo-server-express");
const { port, accounts_port, cards_port } = require("./config")

const express = require("express");
const expressJwt = require("express-jwt");

const app = express();

app.use(
  expressJwt({
    secret: "f1BtnWgD3VKY", // TODO move to envs
    algorithms: ["HS256"],
    credentialsRequired: false
  })
);

const gateway = new ApolloGateway({
  serviceList: [
    { name: "accounts", url: `http://0.0.0.0:${accounts_port}`},
    { name: "cards", url: `http://0.0.0.0:${cards_port}`}
  ],
  buildService({ name, url }) {
    return new RemoteGraphQLDataSource({
      url,
      willSendRequest({ request, context }) {
        request.http.headers.set(
          "user",
          context.user ? JSON.stringify(context.user) : null
        );
      }
    });
  }
});

const server = new ApolloServer({
  gateway,
  subscriptions: false,
  context: ({ req }) => {
    const user = req.user || null;
    return { user };
  },
  introspection: true,
});

server.applyMiddleware({ app });

app.listen({ port }, () =>
  console.log(`Listening on  ${port}${server.graphqlPath}`)
);
