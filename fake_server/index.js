const { ApolloGateway, RemoteGraphQLDataSource } = require("@apollo/gateway");
const { ApolloServer } = require("apollo-server-express");
const { port, acccounts_port } = require("./config")

const express = require("express");
const expressJwt = require("express-jwt");

const app = express();

app.use(
  expressJwt({
    secret: "f1BtnWgD3VKY",
    algorithms: ["HS256"],
    credentialsRequired: false
  })
);

const gateway = new ApolloGateway({
  serviceList: [{ name: "accounts", url: `http://localhost:${acccounts_port}`}],
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
  }
});

server.applyMiddleware({ app });

app.listen({ port }, () =>
  console.log(`Server ready at http://localhost:${port}${server.graphqlPath}`)
);
