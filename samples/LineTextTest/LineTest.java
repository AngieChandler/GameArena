public class LineTest
{
	public static void main(String[] args)
	{
		GameArena a = new GameArena(600,600);
		Line l = new Line(50,50, 400, 500, 10, "GREEN");
        Ball b = new Ball(100,100,10,"RED");
        Text t = new Text("Hello World", 100,200,10,"RED");

		a.addLine(l);
		a.addBall(b);
        a.addText(t);

        double width = 10;
        double speed = 1;

		while(true)
        {
            width += speed;
            if (width >= 50 || width <= 10)
                speed = -speed;

            t.setSize(width);

			a.update();

        }
	}
}
