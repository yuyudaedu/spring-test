


public class LambdaTest {
    //内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        //#1 外部类
        ILike like = new Like();
        like.lambda();

        //#2 类内部类
        like = new Like2();
        like.lambda();

        //#3 匿名内部类
        like = new Like() {
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        };
        like.lambda();

        //#4 方法内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        }
        like = new Like3();
        like.lambda();

        //#5 lambda
        like = ()-> {
            System.out.println("I like lambda5");
        };
        like.lambda();

    }

}

interface ILike {
    void lambda();
}

class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}


