let connect = require('connect');
let serverConfig = require("./server.config");
let serveStatic = require('serve-static');

connect().use(serveStatic(__dirname)).listen(serverConfig.PORT, function () {
    console.log('Server running on 8000...');
});