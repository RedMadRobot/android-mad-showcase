module.exports = {
  accounts: [
    {
      id: "12345",
      name: "QA",
      email: "robot@redmadrobot.com",
      password: "Qq!11111",
      roles: ["admin"],
      permissions: ["read:any_account", "read:own_account"]
    },
    {
      id: "67890",
      name: "qa",
      email: "qa@redmadrobot.com",
      password: "Qq!11111",
      roles: ["subscriber"],
      permissions: ["read:own_account"]
    }
  ],
  cards: [
    {
      id: "1",
      type: "VISA",
      number: "•• 3456",
      color: "pink"
    },
    {
      id: "2",
      type: "MASTER_CARD",
      number: "•• 3439",
      color: "yellow"
    },
    {
      id: "3",
      type: "MASTER_CARD",
      number: "•• 1234",
      color: "red"
    },
    {
      id: "4",
      type: "VISA",
      number: "•• 4123",
      color: "green"
    },
    {
      id: "5",
      type: "VISA",
      number: "•• 4357",
      color: "blue"
    },
    {
      id: "6",
      type: "MASTER_CARD",
      number: "•• 4444",
      color: "red"
    },
    {
      id: "7",
      type: "MASTER_CARD",
      number: "•• 2883",
      color: "pink"
    },
    {
      id: "8",
      type: "MASTER_CARD",
      number: "•• 2333",
      color: "yellow"
    }
  ]
};
