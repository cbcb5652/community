package com.gudf.community;

public class test1 {
}
//
//        //这里求出来了prices这个数组中的平均值赋给price_mean
//          price_mean = np.mean(prices)
//
//        # Step 2.创建布尔数组
//        //把上面的平均值跟价格的数组比较
//        //比如:prices=[10,20,30,40]
//        //那么平均值price_mean就是25
//        boolean_array = (prices>price_mean)//比较之后生成一个布尔数组比25大的是false比25小的是false
//                                            所以这个数组是:[false,false,true,true]
//        print(boolean_array)//打印这个数组
//        # Step 3.选择大于平均值的价格
//        above_avg = prices[boolean_array]   //将存在布尔数组里面的值去取对应在prices数组里面的值，只有true才可以有值
//        print(above_avg)//所以最后输出[30,40]