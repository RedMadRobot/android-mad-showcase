const { ApolloServer, gql } = require("apollo-server");
const { applyMiddleware } = require("graphql-middleware");
const { buildFederatedSchema } = require("@apollo/federation");

const { cards } = require("../../data");
const permissions = require("./permissions");

const { cards_port } = require("../../config")

const typeDefs = gql`
  type Card @key(fields: "id") {
    id: ID!
    type: String!
    number: String!
    color: String!
  }
  extend type Query {
    card(id: ID!): Card
    cards: [Card]
  }
`;

const resolvers = {
  Card: {
    __resolveReference(object) {
      return cards.find(card => card.id === object.id);
    }
  },
  Query: {
    card(_, { id }) {
      return cards.find(card => card.id === id);
    },
    cards() {
      return cards;
    }
  }
};

const server = new ApolloServer({
  schema: applyMiddleware(
    buildFederatedSchema([{ typeDefs, resolvers }])
    // todo add permissions
  ),
  context: ({ req }) => {
    const user = req.headers.user ? JSON.parse(req.headers.user) : null;
    return { user };
  }
});

server.listen({ port: cards_port }).then(({ url }) => {
  console.log(`Cards service ready at ${url}`);
});