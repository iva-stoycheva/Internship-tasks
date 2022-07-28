const http = require('http');

const server = http.createServer(function(req, res) {
  let mathExpression = '';
  let result = ''
  req.on('data', function(data) {
    mathExpression += data;
    result += eval(mathExpression);
  })
  req.on('end', function() {
    res.end(result);
  })
}).listen(8082)