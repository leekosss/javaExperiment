package four;

//直线类
public class Line {
    private Point start;
    private Point end;

    //点类
    public class Point implements Direction {
        private int x;
        private int y;

        public void setPosition(int x,int y) {
            this.x = x;
            this.y = y;
        }

        public Point() {
            setPosition(0,0);
        }

        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }



        public String show() {
            return "(" + x + ","+y+") ";
        }
    }

    public Line() {
        this(0,0,0,0);
    }

    public Line(Point start,Point end) {
        this.start = start;
        this.end = end;
    }
    public Line(int x1,int y1,int x2,int y2) {
        start = new Point(x1,y1);
        end = new Point(x2,y2);
    }
    public void show() {
        System.out.println("该直线所处位置为:" +start.show() + "=>" + end.show());
    }
}
