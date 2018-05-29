/*
 * The MIT License
 *
 * Copyright 2018 Maikel Chandika <mkdika@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.mkdika.lwa.app.item;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 */
public class ItemServiceImpl implements ItemService {
    
    @Inject
    private JdbcPooledConnectionSource connection;

    private final Dao<Item, Integer> itemDao;

    public ItemServiceImpl() throws SQLException {
        itemDao = DaoManager.createDao(connection, Item.class);
    }

    @Override
    public List<Item> findAllCustomer() throws SQLException {
        return itemDao.queryForAll();
    }

    @Override
    public Item findCustomerById(int id) throws SQLException {
        return itemDao.queryForId(id);
    }

    @Override
    public void insertCustomer(Item item) throws SQLException {
        itemDao.create(item);
    }

    @Override
    public void updateCustomer(Item item) throws SQLException {
        itemDao.update(item);
    }

    @Override
    public void deleteCustomer(Item item) throws SQLException {
        itemDao.delete(item);
    }

}
