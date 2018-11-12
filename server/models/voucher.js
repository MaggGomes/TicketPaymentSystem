'use strict';
module.exports = (sequelize, DataTypes) => {
    const Voucher = sequelize.define('Voucher', {
        available: {
            type: DataTypes.BOOLEAN,
            allowNull: false,
            default: true
        },
        orderId: {
            type: DataTypes.INTEGER,
            allowNull: true
        },
        userId: {
            type: DataTypes.INTEGER,
            allowNull: false
        }
    }, {});
    Voucher.associate = function(models) {
        Voucher.belongsTo(models.User, {
            foreignKey: 'userId'
        });
        Voucher.belongsTo(models.Order, {
            foreignKey: 'orderId'
        });
    };
    return Voucher;
};