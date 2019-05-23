/*
 * ************************************************************
 * 文件：HttpCacheDao.java  模块：http-core  项目：component
 * 当前修改时间：2019年05月22日 10:49:05
 * 上次修改时间：2019年04月26日 22:46:37
 * 作者：Cody.yi   https://github.com/codyer
 *
 * 描述：http-core
 * Copyright (c) 2019
 * ************************************************************
 */

package com.cody.http.core.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.cody.http.core.db.data.ItemCacheData;

import java.util.List;

/**
 * Created by xu.yi. on 2019/5/22.
 * HttpCacheDao
 */
@Dao
public interface HttpCacheDao {

    @Insert
    long insert(ItemCacheData item);

    @Update
    void update(ItemCacheData item);

    @Query("SELECT * FROM http_cache_table WHERE mKey =:key")
    ItemCacheData queryCacheByKey(String key);

    @Query("SELECT * FROM http_cache_table WHERE mKey =:key")
    LiveData<ItemCacheData> queryCacheByKeyObservable(String key);

    @Query("SELECT * FROM http_cache_table WHERE id =:id")
    LiveData<ItemCacheData> queryCacheObservable(long id);

    @Query("SELECT * FROM http_cache_table")
    List<ItemCacheData> queryAllCache();

    @Query("SELECT * FROM http_cache_table order by id ASC limit :limit")
    LiveData<List<ItemCacheData>> queryAllCacheObservable(int limit);

    @Query("SELECT * FROM http_cache_table order by id ASC")
    LiveData<List<ItemCacheData>> queryAllCacheObservable();

    @Query("DELETE FROM http_cache_table")
    void deleteAll();
}