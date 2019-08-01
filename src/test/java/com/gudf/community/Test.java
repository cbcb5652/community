package com.gudf.community;

public class Test {
    SeasonEnum seasonEnum;

    public Test(SeasonEnum seasonEnum){
        this.seasonEnum = seasonEnum;
    }

    public void say(){
        switch (seasonEnum){
            case SPRING:
                System.out.println(seasonEnum.getSeason()+"||"+seasonEnum.getValue());
                break;
            case SUMMER:
                System.out.println(seasonEnum.getSeason()+"||"+seasonEnum.getValue());
                break;
            case Autumn:
                System.out.println(seasonEnum.getSeason()+"||"+seasonEnum.getValue());
                break;
            case WINTER:
                System.out.println(seasonEnum.getSeason()+"||"+seasonEnum.getValue());
                break;
        }
    }
    public static void main(String[] args) {
        //调用夏天的枚举类
        Test test = new Test(SeasonEnum.SUMMER);
        test.say();
        //下面可以照例调用春天，秋天，冬天
    }

}
