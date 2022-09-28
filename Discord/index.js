const Discord = require ("discord.js")

const Token = "MTAyMDc0MTQwMjgxODI1NjkyNg.GZ304n.6qqR3AaQ8A-e_BMQsb5IhM72-L_j4bLSADUhw0"

const client = new Discord.Client({
    intents: [
        "GUILDS" ,
        "GUILD_MESSAGES"
    ]

})

client.on("ready",   () => {
    console.log (`Logged in as ${client.user.tag}`)
})

client.login(Token)