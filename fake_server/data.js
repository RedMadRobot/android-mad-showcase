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
  ]
};
