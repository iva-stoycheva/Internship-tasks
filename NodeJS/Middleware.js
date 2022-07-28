const express = require("express");
const rateLimit = require("express-rate-limit");

const app = express();
const port = 8085;

const connectionsLimiter = rateLimit({
    max: 20,
    handler: function (req, res) {
        return res.status(429).json({
          error: 'You have reacher maximum connections to this server!'
        })
    }
});

app.use(connectionsLimiter);

app.get("/", connectionsLimiter, (req, res) => res.send("Hello World!"));
app.listen(port, () => console.log(`Server is running on port ${port}`));