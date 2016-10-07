package quarter1;

/*\
:*:
:*: @author Bennett DenBleyker
:*: @author Skyler Cameron
:*:
\*/

public class MathFunctions {
    public static double areaOfCircle(int radiusEntry) { // areaOfCircle takes an integer as input
        return (radiusEntry * radiusEntry) * Math.PI; // Square radius then multiply by pi and return it
    }
    public static double SquareRootAndAddThree(int num) {
        Quarter1.lastEntry = Math.sqrt((double) num) + 3;
        return Quarter1.lastEntry;
    }
}
