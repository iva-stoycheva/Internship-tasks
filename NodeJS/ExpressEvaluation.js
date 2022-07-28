const math = require('mathjs');
const express = require('express'), bodyParser = require('body-parser');
const app = express();
app.use(bodyParser.urlencoded({limit: '2mb', extended:true}));
app.use(express.json());

const port = 8084;

app.listen(
    port, 
    () => console.log(`Server is running on port ${port}`)
);

app.post('/calculator', (req, res) => {
    const expression = req.body.expression;
    const result = math.evaluate(String(expression));
    res.send(`${result}`);
});