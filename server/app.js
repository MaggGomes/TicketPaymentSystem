var express = require('express');
var bodyParser = require('body-parser');
//var pg = require('pg');
Sequelize = require('sequelize');

var app = express();
var index = require('./routes/index');
var users = require('./routes/user');
var shows = require('./routes/show');
var tickets = require('./routes/ticket');
var vouchers = require('./routes/voucher');
var orders = require('./routes/order');
var transactions = require('./routes/transaction');

app.use(bodyParser.json());

app.use('/api', index);
app.use('/api/shows', shows);
app.use('/api/users', users);
app.use('/api/tickets', tickets);
app.use('/api/vouchers', vouchers);
app.use('/api/orders', orders);
app.use('/api/transactions', transactions);

app.use(function(req, res, next) {
	var err = new Error('Not Found');
	err.status = 404;
	next(err);
});

module.exports = app;
