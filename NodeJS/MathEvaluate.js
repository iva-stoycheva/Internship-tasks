const http = require('http')
const math = require('mathjs');

const server = http.createServer(function(req, res) {
  let mathExpression = '';
  let result = ''
  req.on('data', function(data) {
    mathExpression += data;
    result += math.evaluate(mathExpression);
  })
  req.on('end', function() {
    res.end(result);
  })
}).listen(8083)