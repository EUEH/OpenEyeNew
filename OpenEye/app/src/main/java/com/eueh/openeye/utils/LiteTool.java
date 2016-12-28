package com.eueh.openeye.utils;

import com.eueh.openeye.base.MyApp;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.WhereBuilder;

import java.util.List;

/**
 * Created by Even on 16/12/28.
 */

public class LiteTool {

    private static LiteTool ourInstance = new LiteTool();

    //定义一个LiteOrm  在构造方法里面等于MyApp里面的
    private static LiteOrm mLiteOrm;

    public static LiteTool getInstance() {
        if (ourInstance == null) {
            synchronized (LiteTool.class) {
                if (ourInstance == null) {
                    ourInstance = new LiteTool();
                }
            }
        }
        mLiteOrm = MyApp.getmLiteOrm();
        return ourInstance;
    }

    private LiteTool() {
    }

    //下面全是对外提供的方法

    //增加一个
    public <T> void insertOne(T t) {
        mLiteOrm.save(t);
    }

    //删除所有
    public void deleteAll(Class T) {
        mLiteOrm.deleteAll(T);
    }

    //根据年龄删除一个    第二个参数是要删除的那个属性 第三个是要删除根据的值
    public void deleteOne(Class T, String deleteKey, String age) {
        mLiteOrm.delete(new WhereBuilder(T).where(deleteKey + " = ?", new Object[]{age}));
    }

    //查询所有  返回结果是list  <T>是声明T
    public <T> List<T> queryAll(Class T){
        List<T> list = mLiteOrm.query(T);
        return list ;
    }
}
