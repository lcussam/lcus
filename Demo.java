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

}//ö������

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

abstract class CShape //extends CObject     //��CShape����Ϊ������

{



    private static final int HS_CROSS =1 ;

    ElementType Type;			//ͼԪ����

    int OrgX;					//ԭ������

    int OrgY;

    Color  BorderColor;		//�߽���ɫ

    int BorderType;				//�߽�����--ʵ�ߡ����ߡ�����ߵ�

    int BorderWidth;			//�߽���

    Color  FillColor;		//�����ɫ

    int FillType;				//�������--ʵ�ġ�˫�Խǡ�ʮ�ֽ����

    public CShape() {

        ElementType Type = ElementType.NOTSET;

        OrgX = 0;

        OrgY = 0;

        BorderColor=new Color(255,0,0);//BorderColor=RGB(255,0,0);

    	/*BorderType=PS_DOT;

    	BorderWidth=2;*/

        Font font=new Font("Times New Roman",Font.BOLD,2);

        Graphics2D g2;

        Stroke stroke=new BasicStroke(2.0f);//�����߿�Ϊ2.0



        Color FillColor=new Color(0,186,205);//FillColor = RGB(0, 186, 205);

        FillType = HS_CROSS;

    }

    class Inner implements Serializable{



    }

    public abstract void Draw(Graphics g);			//����ͼԪ

    public abstract boolean IsMatched(Point pnt);	//���Ƿ�����ͼ���ڲ�   //���麯��ת�ɳ��󷽷�

    public abstract void Serialize(Serializable ar);

    public void SetPen(Color penColor , int penType , int penWidth ) {//Ĭ�ϣ���ɫˮ��

        Graphics2D g2;

        BasicStroke stroke=new BasicStroke(1.0f);//�����߿�Ϊ3.0



        penColor=new Color(0,0,0);

        BorderColor = penColor;

        //g2.setPaint(PS_SOLID);(PS_SOLID);

        //penType=PS_SOLID;

        BorderType = penType;

        penWidth=1;

        BorderWidth = penWidth;

    }

    public void SetBrush(Color fillColor, int fillType)    //Ĭ�ϣ���ɫˮˢ

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

class CSquare extends CShape			//������

{

    public CSquare() {



    }

    public CSquare(int x, int y, int w) {

        ElementType Type = ElementType.SQUARE;

        OrgX = x;

        OrgY = y;

        width = w;

    }

    public void Draw(Graphics g) {//����������
        Graphics2D g2=(Graphics2D)g;

        BasicStroke stroke=new BasicStroke(3.0f);//�����߿�Ϊ3.0

        g2.setStroke(stroke);

        g2.drawRect(OrgX, OrgY, width,width);



    }

    public boolean IsMatched(Point pnt) {//���ص�pnt�Ƿ�����ͼԪ��

        if (pnt.getX() >= (OrgX - width / 2.0) && pnt.getY() >= (OrgY - width / 2.0) && pnt.getY() <= (OrgY + width / 2.0) && pnt.getX() <= (OrgX + width / 2.0))

            return true;

        else

            return false;

    }

    public void Serialize(Serializable ar) {//���л�������ͼԪ

        if (ar.IsStoring())

        {
            ar << (WORD)Type;
            ar << OrgX << OrgY;	//ԭ������
            ar << BorderColor;	//�߽���ɫ
            ar << BorderType;	//�߽�����
            ar << BorderWidth;	//�߽���
            ar << FillColor;	//�����ɫ
            ar << FillType;		//�������
            ar << width;		//�����α߳�
        }

        else

        {

            WORD w;

            ar >> w;

            ElementType Type = (ElementType)w;

            ar >> OrgX >> OrgY;	//ԭ������

            ar >> BorderColor;	//�߽���ɫ

            ar >> BorderType;	//�߽�����

            ar >> BorderWidth;	//�߽���

            ar >> FillColor;	//�����ɫ

            ar >> FillType;		//�������

            ar >> width;		//�����α߳�

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





    private int width;   //�߳������



    private class WORD {

    }

}



class CRectangle extends CShape

{		//������



    public CRectangle() 	{	}

    public CRectangle(int x, int y, int w, int h) {

        ElementType Type = ElementType.RECTANGLE;

        OrgX = x;

        OrgY = y;

        width = w;

        height = h;

    }

    public void Draw(Graphics g) {//���Ƴ�����

		


        Graphics2D g2=(Graphics2D)g;

        BasicStroke stroke=new BasicStroke(3.0f);//�����߿�Ϊ3.0

        g2.setStroke(stroke);

        g2.drawRect(OrgX, OrgY, width,height);

    }

    public boolean IsMatched(Point pnt) {//���ص�pnt�Ƿ�����ͼԪ��

        if ((pnt.getX() >= OrgX - width / 2.0) && (pnt.getY() >= OrgY - height / 2.0) && (pnt.getX() <= OrgX + width / 2.0) && (pnt.getY() <= OrgY + height / 2.0))

            return true;

        else

            return false;

    }

    public  void Serialize(Serializable ar) {//���л�������ͼԪ

        if (ar.IsStoring())

        {

            ar << (WORD)Type;

            ar << OrgX << OrgY;	//ԭ������

            ar << BorderColor;	//�߽���ɫ

            ar << BorderType;	//�߽�����

            ar << BorderWidth;	//�߽���

            ar << FillColor;	//�����ɫ

            ar << FillType;		//�������

            ar << width;		//�����εĳ�

            ar << height;		//�����εĿ�

        }

        else

        {

            WORD w;

            ar >> w;

            Type = (ElementType)w;

            ar >> OrgX >> OrgY;	//ԭ������

            ar >> BorderColor;	//�߽���ɫ

            ar >> BorderType;	//�߽�����

            ar >> BorderWidth;	//�߽���

            ar >> FillColor;	//�����ɫ

            ar >> FillType;		//�������

            ar >> width;		//�����εĳ�

            ar >> height;		//�����εĿ�

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

    private int width;//���

    private int height;//�߶�

    DECLARE_SERIAL(CRectangle)//������CRectangle֧�����л�

}







class CCircle extends CShape

{			//Բ��



    public CCircle() {



    }

    public CCircle(int x, int y, int r) {

        ElementType Type = ElementType.CIRCLE;

        OrgX = x;

        OrgY = y;

        radius = r;

    }

    public void Draw(Graphics g) {//����Բ��



        Graphics2D g2 = (Graphics2D) g;

        BasicStroke stroke = new BasicStroke(3.0f);//�����߿�Ϊ3.0

        g2.setStroke(stroke);

        g2.drawOval(OrgX - radius, OrgY - radius, OrgX + radius, OrgY + radius);

    }



    public boolean IsMatched(Point pnt) {//���ص�pnt�Ƿ�����ͼԪ��

        if (Math.sqrt(Math.pow((pnt.getX() - OrgX),2) + Math.pow((pnt.getY() - OrgX),2))<= radius)

            return true;

        else

            return false;

    }

    public  void Serialize(Serializable ar) {//���л�Բ��ͼԪ

        if (ar.IsStoring())

        {

            ar << (WORD)Type;

            ar << OrgX << OrgY;	//ԭ������

            ar << BorderColor;	//�߽���ɫ

            ar << BorderType;	//�߽�����

            ar << BorderWidth;	//�߽���

            ar << FillColor;	//�����ɫ

            ar << FillType;		//�������

            ar << radius;		//Բ�εİ뾶

        }

        else

        {

            WORD w;

            ar >> w;

            Type = (ElementType)w;

            ar >> OrgX >> OrgY;	//ԭ������

            ar >> BorderColor;	//�߽���ɫ

            ar >> BorderType;	//�߽�����

            ar >> BorderWidth;	//�߽���

            ar >> FillColor;	//�����ɫ

            ar >> FillType;		//�������

            ar >> radius;		//Բ�εİ뾶

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

    private int radius;//�뾶

    DECLARE_SERIAL(CCircle)//������CCircle֧�����л�

}







class CEllipse extends CShape

{			//��Բ

    public CEllipse() {



    }

    public CEllipse(int x, int y, int w, int h) {

        ElementType Type =ElementType.ELLIPSE;

        OrgX = x;

        OrgY = y;

        width = w;

        height = h;

    }

    public void Draw(Graphics g) {//������Բ



        Graphics2D g2 = (Graphics2D) g;

        BasicStroke stroke = new BasicStroke(3.0f);//�����߿�Ϊ3.0

        g2.setStroke(stroke);

        g2.drawOval(OrgX - (width / 2), OrgY - (height / 2), OrgX + (width / 2), OrgY + (height / 2));



    }

   
    public boolean IsMatched(Point pnt) {//���ص�pnt�Ƿ�����ͼԪ��

        if ((Math.pow((pnt.getX() - OrgX), 2) / Math.pow((width / 2.0), 2) + Math.pow((pnt.getY() - OrgY), 2) / Math.pow((height / 2.0), 2)) <= 1)

            return true;

        else

            return false;

    }

    public  void Serialize(Serializable ar) {//���л�Բ��ͼԪ

        if (ar.IsStoring())

        {

            ar << (WORD)Type;

            ar << OrgX << OrgY;	//ԭ������

            ar << BorderColor;	//�߽���ɫ

            ar << BorderType;	//�߽�����

            ar << BorderWidth;	//�߽���

            ar << FillColor;	//�����ɫ

            ar << FillType;		//�������

            ar << width;		//��Բ�ĳ���

            ar << height;		//��Բ�Ķ���

        }

        else

        {

            WORD w;

            ar >> w;

            Type = (ElementType)w;

            ar >> OrgX >> OrgY;	//ԭ������

            ar >> BorderColor;	//�߽���ɫ

            ar >> BorderType;	//�߽�����

            ar >> BorderWidth;	//�߽���

            ar >> FillColor;	//�����ɫ

            ar >> FillType;		//�������

            ar >> width;		//��Բ�ĳ���

            ar >> height;		//��Բ�Ķ���

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

    private int width;      //������̰���

    private int height;

    DECLARE_SERIAL(CEllipse)//������CEllipse֧�����л�

}







class CTriangle extends CShape

{		//������

    public CTriangle() {}

    public CTriangle(int x, int y, int w) {

        ElementType Type = ElementType.TRIANGLE;

        OrgX = x;

        OrgY = y;

        width = w;

    }

   

   public void Draw(Graphics g) {//����������

        
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

       BasicStroke stroke = new BasicStroke(3.0f);//�����߿�Ϊ3.0

       g2.setStroke(stroke);

       g2.drawPolygon(xPoint,yPoint, 3);



   }

    public boolean IsMatched(Point pnt) {//���ص�pnt�Ƿ�����ͼԪ��

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

            Point p2 = point[(i + 1) % 3];// ���һ�������һ��������

            if (p1.getY() == p2.getY())

                continue;

            if (pnt.getY() < Math.min(p1.getY(), p2.getY()))

                continue;

            if (pnt.getY() >= Math.max(p1.getY(), p2.getY()))

                continue;

            // �󽻵��x����

            double x = (double)(pnt.getY() - p1.getY()) * (double)(p2.getX() - p1.getX()) / (double)(p2.getY() - p1.getY()) + p1.getX();

            // ֻͳ��p1p2��p�������ߵĽ���

            if (x > pnt.getX())

            {

                nCross++;

            }

        }



        // ����Ϊż�������ڶ����֮��



        if (nCross % 2 == 1) {

            return true;

        }

        else {

            return false;

        }

    }

    public  void Serialize(Serializable ar) {//���л�Բ��ͼԪ

        if (ar.IsStoring())

        {

            ar << (WORD)Type;

            ar << OrgX << OrgY;	//ԭ������

            ar << BorderColor;	//�߽���ɫ

            ar << BorderType;	//�߽�����

            ar << BorderWidth;	//�߽���

            ar << FillColor;	//�����ɫ

            ar << FillType;		//�������

            ar << width;		//�������εı߳�

        }

        else

        {

            WORD w;

            ar >> w;

            Type = (ElementType)w;

            ar >> OrgX >> OrgY;	//ԭ������

            ar >> BorderColor;	//�߽���ɫ

            ar >> BorderType;	//�߽�����

            ar >> BorderWidth;	//�߽���

            ar >> FillColor;	//�����ɫ

            ar >> FillType;		//�������

            ar >> width;		//�������εı߳�

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

    DECLARE_SERIAL(CTriangle)//������CTriangle֧�����л�

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

{		//�ı�

    public CText() {}

    public CText(int x, int y, int h, int a, String t) {

        ElementType Type =ElementType .TEXT;

        OrgX = x;

        OrgY = y;

        height = h;

        angle = a;

        text = t;

    }

    public void Draw(Graphics g) {//�����ı�



        Graphics2D g2 = (Graphics2D) g;

        BasicStroke stroke = new BasicStroke(3.0f);//�����߿�Ϊ3.0

        g2.setStroke(stroke);



        Font font = new Font("�����п�", Font.BOLD + Font.ITALIC, 26); // �����������

        g.setFont(font); // ��������

        g.drawString(text, OrgX, OrgY); // �����ı�

    }
    public boolean IsMatched(Point pnt)//���ص�pnt�Ƿ�����ͼԪ��

    {

        double width, height;

        Csize size=new Csize();

        width = size.getXc();									// cx��cy�ֱ��ǿ�Ⱥ͸߶�

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

            Point p2 = p[(i + 1) % 4];// ���һ�������һ��������

            if (p1.getY() == p2.getY())

                continue;

            if (pnt.getY() < Math.min(p1.getY(), p2.getY()))

                continue;

            if (pnt.getY() >= Math.max(p1.getY(), p2.getY()))

                continue;

            // �󽻵��x����

            double x = (double)(pnt.getY() - p1.getY()) * (double)(p2.getX() - p1.getX()) / (double)(p2.getY() - p1.getY()) + p1.getX();

            // ֻͳ��p1p2��p�������ߵĽ���

            if (x > pnt.getX())

            {

                nCross++;

            }

        }    // ����Ϊż�������ڶ����֮��

        if (nCross % 2 == 1) {

            return true;

        }

        else {

            return false;

        }

    }

    public  void Serialize(Serializable ar) {//���л�ͼԪ

        if (ar.IsStoring())

        {

            ar << (WORD)Type;

            ar << OrgX << OrgY;	//ԭ������

            ar << BorderColor;	//�߽���ɫ

            ar << BorderType;	//�߽�����

            ar << BorderWidth;	//�߽���

            ar << FillColor;	//�����ɫ

            ar << FillType;		//�������

            ar << height;		//�ı��ĸ�

            ar << angle;		//�ı���X��ĽǶ�

            ar << text;			//�ı�����

            ar << size;

        }

        else

        {

            WORD w;

            ar >> w;

            Type = (ElementType)w;

            ar >> OrgX >> OrgY;	//ԭ������

            ar >> BorderColor;	//�߽���ɫ

            ar >> BorderType;	//�߽�����

            ar >> BorderWidth;	//�߽���

            ar >> FillColor;	//�����ɫ

            ar >> FillType;		//�������

            ar >> height;		//�ı��ĸ�

            ar >> angle;		//�ı���X��ĽǶ�

            ar >> text;			//�ı�����

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

    DECLARE_SERIAL(CText)//������CText֧�����л�

}