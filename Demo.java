package test1;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.io.Serializable;
import static java.lang.StrictMath.sin;
import java.awt.*;
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
enum ElementType {

    NOTSET, SQUARE, RECTANGLE, CIRCLE, ELLIPSE, TRIANGLE, TEXT

}//枚举类型

class Point{

    private double x;

    private double y;

    public void setX(double x) {

        this.x=x;

    }

    public void setY(double y) {

        this.y=y;

    }

    public double getX() {

        return this.x;

    }

    public double getY() {

        return this.y;

    }

}

abstract class CShape //extends CObject     //将CShape定义为抽象类

{



    private static final int HS_CROSS =1 ;

    ElementType Type;			//图元类型

    int OrgX;					//原点坐标

    int OrgY;

    Color  BorderColor;		//边界颜色

    int BorderType;				//边界线型--实线、虚线、虚点线等

    int BorderWidth;			//边界宽度

    Color  FillColor;		//填充颜色

    int FillType;				//填充类型--实心、双对角、十字交叉等

    public CShape() {

        ElementType Type = ElementType.NOTSET;

        OrgX = 0;

        OrgY = 0;

        BorderColor=new Color(255,0,0);//BorderColor=RGB(255,0,0);

    	/*BorderType=PS_DOT;

    	BorderWidth=2;*/

        Font font=new Font("Times New Roman",Font.BOLD,2);

        Graphics2D g2;

        Stroke stroke=new BasicStroke(2.0f);//设置线宽为2.0



        Color FillColor=new Color(0,186,205);//FillColor = RGB(0, 186, 205);

        FillType = HS_CROSS;

    }

    class Inner implements Serializable{



    }

    public abstract void Draw(Graphics g);			//绘制图元

    public abstract boolean IsMatched(Point pnt);	//点是否落在图形内部   //纯虚函数转成抽象方法

    public abstract void Serialize(Serializable ar);

    public void SetPen(Color penColor , int penType , int penWidth ) {//默认：黑色水笔

        Graphics2D g2;

        BasicStroke stroke=new BasicStroke(1.0f);//设置线宽为3.0



        penColor=new Color(0,0,0);

        BorderColor = penColor;

        //g2.setPaint(PS_SOLID);(PS_SOLID);

        //penType=PS_SOLID;

        BorderType = penType;

        penWidth=1;

        BorderWidth = penWidth;

    }

    public void SetBrush(Color fillColor, int fillType)    //默认：蓝色水刷

    {

        fillColor=new Color(0,0,255);

        FillColor = fillColor;

        //fillType = HS_DIAGCROSS + 1;

        FillType = fillType;

    }

    public void GetPen(Color penColor, int penType, int penWidth) {

        penColor = BorderColor;

        penType = BorderType;

        penWidth = BorderWidth;

    }

    public void GetBrush(Color  fillColor, int  fillType)

    {

        fillColor = FillColor;

        fillType = FillType;

    }

    public abstract void SetValue(int x, int y, int w_r, int h, String s);

    public abstract void GetValue(int type, int x, int  y, int  w_r , int  h, String s);

}

class CSquare extends CShape			//正方形

{

    public CSquare() {



    }

    public CSquare(int x, int y, int w) {

        ElementType Type = ElementType.SQUARE;

        OrgX = x;

        OrgY = y;

        width = w;

    }

    public void Draw(Graphics g) {//绘制正方形
        Graphics2D g2=(Graphics2D)g;

        BasicStroke stroke=new BasicStroke(3.0f);//设置线宽为3.0

        g2.setStroke(stroke);

        g2.drawRect(OrgX, OrgY, width,width);



    }

    public boolean IsMatched(Point pnt) {//重载点pnt是否落在图元内

        if (pnt.getX() >= (OrgX - width / 2.0) && pnt.getY() >= (OrgY - width / 2.0) && pnt.getY() <= (OrgY + width / 2.0) && pnt.getX() <= (OrgX + width / 2.0))

            return true;

        else

            return false;

    }

    public void Serialize(Serializable ar) {//序列化正方形图元

        if (ar.IsStoring())

        {
            ar << (WORD)Type;
            ar << OrgX << OrgY;	//原点坐标
            ar << BorderColor;	//边界颜色
            ar << BorderType;	//边界线型
            ar << BorderWidth;	//边界宽度
            ar << FillColor;	//填充颜色
            ar << FillType;		//填充类型
            ar << width;		//正方形边长
        }

        else

        {

            WORD w;

            ar >> w;

            ElementType Type = (ElementType)w;

            ar >> OrgX >> OrgY;	//原点坐标

            ar >> BorderColor;	//边界颜色

            ar >> BorderType;	//边界线型

            ar >> BorderWidth;	//边界宽度

            ar >> FillColor;	//填充颜色

            ar >> FillType;		//填充类型

            ar >> width;		//正方形边长

        }

    }

    public void SetValue(int x, int y, int w_r, int h, String s) {

        OrgX = x;

        OrgY = y;

        width = w_r;

    }

    public void GetValue(int type, int  x, int  y, int  w_r , int  h, String  s) {

        type = 0;

        x = OrgX;

        y = OrgY;

        w_r = width;

    }





    private int width;   //边长即宽度



    private class WORD {

    }

}



class CRectangle extends CShape

{		//长方形



    public CRectangle() 	{	}

    public CRectangle(int x, int y, int w, int h) {

        ElementType Type = ElementType.RECTANGLE;

        OrgX = x;

        OrgY = y;

        width = w;

        height = h;

    }

    public void Draw(Graphics g) {//绘制长方形

		


        Graphics2D g2=(Graphics2D)g;

        BasicStroke stroke=new BasicStroke(3.0f);//设置线宽为3.0

        g2.setStroke(stroke);

        g2.drawRect(OrgX, OrgY, width,height);

    }

    public boolean IsMatched(Point pnt) {//重载点pnt是否落在图元内

        if ((pnt.getX() >= OrgX - width / 2.0) && (pnt.getY() >= OrgY - height / 2.0) && (pnt.getX() <= OrgX + width / 2.0) && (pnt.getY() <= OrgY + height / 2.0))

            return true;

        else

            return false;

    }

    public  void Serialize(Serializable ar) {//序列化长方形图元

        if (ar.IsStoring())

        {

            ar << (WORD)Type;

            ar << OrgX << OrgY;	//原点坐标

            ar << BorderColor;	//边界颜色

            ar << BorderType;	//边界线型

            ar << BorderWidth;	//边界宽度

            ar << FillColor;	//填充颜色

            ar << FillType;		//填充类型

            ar << width;		//长方形的长

            ar << height;		//长方形的宽

        }

        else

        {

            WORD w;

            ar >> w;

            Type = (ElementType)w;

            ar >> OrgX >> OrgY;	//原点坐标

            ar >> BorderColor;	//边界颜色

            ar >> BorderType;	//边界线型

            ar >> BorderWidth;	//边界宽度

            ar >> FillColor;	//填充颜色

            ar >> FillType;		//填充类型

            ar >> width;		//长方形的长

            ar >> height;		//长方形的宽

        }

    }

    public void SetValue(int x, int y, int w_r, int h, String s) {

        OrgX = x;

        OrgY = y;

        width = w_r;

        height = h;

    }

    public void GetValue(int type, int  x, int  y, int  w_r, int  h, String s) {

        type = 1;

        x = OrgX;

        y = OrgY;

        w_r = width;

        h = height;

    }

    private int width;//宽度

    private int height;//高度

    DECLARE_SERIAL(CRectangle)//声明类CRectangle支持序列化

}







class CCircle extends CShape

{			//圆形



    public CCircle() {



    }

    public CCircle(int x, int y, int r) {

        ElementType Type = ElementType.CIRCLE;

        OrgX = x;

        OrgY = y;

        radius = r;

    }

    public void Draw(Graphics g) {//绘制圆形



        Graphics2D g2 = (Graphics2D) g;

        BasicStroke stroke = new BasicStroke(3.0f);//设置线宽为3.0

        g2.setStroke(stroke);

        g2.drawOval(OrgX - radius, OrgY - radius, OrgX + radius, OrgY + radius);

    }



    public boolean IsMatched(Point pnt) {//重载点pnt是否落在图元内

        if (Math.sqrt(Math.pow((pnt.getX() - OrgX),2) + Math.pow((pnt.getY() - OrgX),2))<= radius)

            return true;

        else

            return false;

    }

    public  void Serialize(Serializable ar) {//序列化圆形图元

        if (ar.IsStoring())

        {

            ar << (WORD)Type;

            ar << OrgX << OrgY;	//原点坐标

            ar << BorderColor;	//边界颜色

            ar << BorderType;	//边界线型

            ar << BorderWidth;	//边界宽度

            ar << FillColor;	//填充颜色

            ar << FillType;		//填充类型

            ar << radius;		//圆形的半径

        }

        else

        {

            WORD w;

            ar >> w;

            Type = (ElementType)w;

            ar >> OrgX >> OrgY;	//原点坐标

            ar >> BorderColor;	//边界颜色

            ar >> BorderType;	//边界线型

            ar >> BorderWidth;	//边界宽度

            ar >> FillColor;	//填充颜色

            ar >> FillType;		//填充类型

            ar >> radius;		//圆形的半径

        }

    }

    public void SetValue(int x, int y, int w_r,  int h, String s) {

        OrgX = x;

        OrgY = y;

        radius = w_r;

    }

    public void GetValue(int type, int  x, int  y, int  w_r, int  h, String  s) {

        type = 2;

        x = OrgX;

        y = OrgY;

        w_r = radius;

    }

    private int radius;//半径

    DECLARE_SERIAL(CCircle)//声明类CCircle支持序列化

}







class CEllipse extends CShape

{			//椭圆

    public CEllipse() {



    }

    public CEllipse(int x, int y, int w, int h) {

        ElementType Type =ElementType.ELLIPSE;

        OrgX = x;

        OrgY = y;

        width = w;

        height = h;

    }

    public void Draw(Graphics g) {//绘制椭圆



        Graphics2D g2 = (Graphics2D) g;

        BasicStroke stroke = new BasicStroke(3.0f);//设置线宽为3.0

        g2.setStroke(stroke);

        g2.drawOval(OrgX - (width / 2), OrgY - (height / 2), OrgX + (width / 2), OrgY + (height / 2));



    }

   
    public boolean IsMatched(Point pnt) {//重载点pnt是否落在图元内

        if ((Math.pow((pnt.getX() - OrgX), 2) / Math.pow((width / 2.0), 2) + Math.pow((pnt.getY() - OrgY), 2) / Math.pow((height / 2.0), 2)) <= 1)

            return true;

        else

            return false;

    }

    public  void Serialize(Serializable ar) {//序列化圆形图元

        if (ar.IsStoring())

        {

            ar << (WORD)Type;

            ar << OrgX << OrgY;	//原点坐标

            ar << BorderColor;	//边界颜色

            ar << BorderType;	//边界线型

            ar << BorderWidth;	//边界宽度

            ar << FillColor;	//填充颜色

            ar << FillType;		//填充类型

            ar << width;		//椭圆的长轴

            ar << height;		//椭圆的短轴

        }

        else

        {

            WORD w;

            ar >> w;

            Type = (ElementType)w;

            ar >> OrgX >> OrgY;	//原点坐标

            ar >> BorderColor;	//边界颜色

            ar >> BorderType;	//边界线型

            ar >> BorderWidth;	//边界宽度

            ar >> FillColor;	//填充颜色

            ar >> FillType;		//填充类型

            ar >> width;		//椭圆的长轴

            ar >> height;		//椭圆的短轴

        }

    }

    public void SetValue(int x, int y, int w_r,  int h, String s) {

        OrgX = x;

        OrgY = y;

        width = w_r;

        height = h;

    }

    public void GetValue(int type, int  x, int  y, int  w_r, int  h, String  s) {

        type = 3;

        x = OrgX;

        y = OrgY;

        w_r = width;

        h = height;

    }

    private int width;      //长半轴短半轴

    private int height;

    DECLARE_SERIAL(CEllipse)//声明类CEllipse支持序列化

}







class CTriangle extends CShape

{		//三角形

    public CTriangle() {}

    public CTriangle(int x, int y, int w) {

        ElementType Type = ElementType.TRIANGLE;

        OrgX = x;

        OrgY = y;

        width = w;

    }

   

   public void Draw(Graphics g) {//绘制三角形

        
       Point point[]=new Point[3];

       point[0].setX(OrgX);

       double y1= OrgY - width * 1.0 / Math.sqrt(3);

       point[0].setY(y1);

       point[1].setX(OrgX - width / 2.0);

       point[1].setY(OrgY + width * 0.5 / Math.sqrt(3));

       point[2].setX(OrgX + width / 2.0);

       point[2].setY(OrgY + width * 0.5 / Math.sqrt(3));

       int xPoint[]=new int[3];

       xPoint[0]= (int) point[0].getX();

       xPoint[1]= (int) point[1].getX();

       xPoint[2]= (int) point[2].getX();

       int yPoint[]=new int[3];

       yPoint[0]= (int) point[0].getY();

       yPoint[1]= (int) point[1].getY();

       yPoint[2]= (int) point[2].getY();



       Graphics2D g2 = (Graphics2D) g;

       BasicStroke stroke = new BasicStroke(3.0f);//设置线宽为3.0

       g2.setStroke(stroke);

       g2.drawPolygon(xPoint,yPoint, 3);



   }

    public boolean IsMatched(Point pnt) {//重载点pnt是否落在图元内

        Point point[]=new Point[3];

        point[0].setX(OrgX);

        double y1= OrgY - width * 1.0 / Math.sqrt(3);

        point[0].setY(y1);



        point[1].setX(OrgX - width / 2.0);

        point[1].setY(OrgY + width * 0.5 / Math.sqrt(3));

        point[2].setX(OrgX + width / 2.0);

        point[2].setY(OrgY + width * 0.5 / Math.sqrt(3));



        int nCross = 0;

        for (int i = 0; i < 3; i++)

        {

            Point p1 = point[i];

            Point p2 = point[(i + 1) % 3];// 最后一个点与第一个点连线

            if (p1.getY() == p2.getY())

                continue;

            if (pnt.getY() < Math.min(p1.getY(), p2.getY()))

                continue;

            if (pnt.getY() >= Math.max(p1.getY(), p2.getY()))

                continue;

            // 求交点的x坐标

            double x = (double)(pnt.getY() - p1.getY()) * (double)(p2.getX() - p1.getX()) / (double)(p2.getY() - p1.getY()) + p1.getX();

            // 只统计p1p2与p向右射线的交点

            if (x > pnt.getX())

            {

                nCross++;

            }

        }



        // 交点为偶数，点在多边形之外



        if (nCross % 2 == 1) {

            return true;

        }

        else {

            return false;

        }

    }

    public  void Serialize(Serializable ar) {//序列化圆形图元

        if (ar.IsStoring())

        {

            ar << (WORD)Type;

            ar << OrgX << OrgY;	//原点坐标

            ar << BorderColor;	//边界颜色

            ar << BorderType;	//边界线型

            ar << BorderWidth;	//边界宽度

            ar << FillColor;	//填充颜色

            ar << FillType;		//填充类型

            ar << width;		//正三角形的边长

        }

        else

        {

            WORD w;

            ar >> w;

            Type = (ElementType)w;

            ar >> OrgX >> OrgY;	//原点坐标

            ar >> BorderColor;	//边界颜色

            ar >> BorderType;	//边界线型

            ar >> BorderWidth;	//边界宽度

            ar >> FillColor;	//填充颜色

            ar >> FillType;		//填充类型

            ar >> width;		//正三角形的边长

        }

    }

    public void SetValue(int x, int y, int w_r,  int h, String s) {

        OrgX = x;

        OrgY = y;

        width = w_r;

    }

    public void GetValue(int type, int  x, int  y, int  w_r, int  h, String  s) {



        type = 4;

        x = OrgX;

        y = OrgY;

        w_r = width;

    }

    private int width;

    DECLARE_SERIAL(CTriangle)//声明类CTriangle支持序列化

}



class Csize{

    private double cx;

    private double cy;

    public void setXc(double x) {

        this.cx=x;

    }

    public void setYc(double y) {

        this.cy=y;

    }

    public double getXc() {

        return this.cx;

    }

    public double getYc() {

        return this.cy;

    }

}



class CText extends CShape

{		//文本

    public CText() {}

    public CText(int x, int y, int h, int a, String t) {

        ElementType Type =ElementType .TEXT;

        OrgX = x;

        OrgY = y;

        height = h;

        angle = a;

        text = t;

    }

    public void Draw(Graphics g) {//绘制文本



        Graphics2D g2 = (Graphics2D) g;

        BasicStroke stroke = new BasicStroke(3.0f);//设置线宽为3.0

        g2.setStroke(stroke);



        Font font = new Font("华文行楷", Font.BOLD + Font.ITALIC, 26); // 创建字体对象

        g.setFont(font); // 设置字体

        g.drawString(text, OrgX, OrgY); // 绘制文本

    }
    public boolean IsMatched(Point pnt)//重载点pnt是否落在图元内

    {

        double width, height;

        Csize size=new Csize();

        width = size.getXc();									// cx、cy分别是宽度和高度

        height = size.getYc();

        double a = angle * 3.1415926 / 180;

            Point p[]=new Point [4];

        p[0].setX(OrgX);

        p[0].setY(OrgY);

        p[1].setX(OrgX + height * sin(a));

        p[1].setY(OrgY + height * Math.cos(a));

        p[2].setX(OrgX + height * sin(a) + width * Math.cos(a));

        p[2].setY(OrgY + height * Math.cos(a) - width * sin(a));

        p[3].setX(OrgX + width * Math.cos(a));

        p[3].setY(OrgY - width * sin(a));

        int nCross = 0;

        for (int i = 0; i < 4; i++)

        {

            Point p1 = p[i];

            Point p2 = p[(i + 1) % 4];// 最后一个点与第一个点连线

            if (p1.getY() == p2.getY())

                continue;

            if (pnt.getY() < Math.min(p1.getY(), p2.getY()))

                continue;

            if (pnt.getY() >= Math.max(p1.getY(), p2.getY()))

                continue;

            // 求交点的x坐标

            double x = (double)(pnt.getY() - p1.getY()) * (double)(p2.getX() - p1.getX()) / (double)(p2.getY() - p1.getY()) + p1.getX();

            // 只统计p1p2与p向右射线的交点

            if (x > pnt.getX())

            {

                nCross++;

            }

        }    // 交点为偶数，点在多边形之外

        if (nCross % 2 == 1) {

            return true;

        }

        else {

            return false;

        }

    }

    public  void Serialize(Serializable ar) {//序列化图元

        if (ar.IsStoring())

        {

            ar << (WORD)Type;

            ar << OrgX << OrgY;	//原点坐标

            ar << BorderColor;	//边界颜色

            ar << BorderType;	//边界线型

            ar << BorderWidth;	//边界宽度

            ar << FillColor;	//填充颜色

            ar << FillType;		//填充类型

            ar << height;		//文本的高

            ar << angle;		//文本与X轴的角度

            ar << text;			//文本内容

            ar << size;

        }

        else

        {

            WORD w;

            ar >> w;

            Type = (ElementType)w;

            ar >> OrgX >> OrgY;	//原点坐标

            ar >> BorderColor;	//边界颜色

            ar >> BorderType;	//边界线型

            ar >> BorderWidth;	//边界宽度

            ar >> FillColor;	//填充颜色

            ar >> FillType;		//填充类型

            ar >> height;		//文本的高

            ar >> angle;		//文本与X轴的角度

            ar >> text;			//文本内容

            ar >> size;

        }

    }



    public void SetValue(int x, int y, int w_r,  int h, String s) {

        OrgX = x;

        OrgY = y;

        angle = w_r;

        height = h;

        text = s;

    }

    public void GetValue(int type, int  x, int  y, int  w_r, int  h, String  s) {

        type = 5;

        x = OrgX;

        y = OrgY;

        w_r = angle;

        h = height;

        s = text;

    }

    private int height;

    private int angle;

    private String text;

    private Size size;

    DECLARE_SERIAL(CText)//声明类CText支持序列化

}