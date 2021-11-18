/*
 *   Author: Tyler Osborne
 *   Date: 2021-11-18
 *   Description:
 *       this Class represents a 2 Dimensional point
 * */
package ca.durhamcollege;

import java.util.Vector;

public class Vector2D
{
    //<editor-fold desc="PRIVATE INSTANCE VARIABLES">
    private float x;
    private float y;
    // END PRIVATE INSTANCE VARIABLES
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    // Default constructor
    Vector2D()
    {
        set(zero());
    }

    // Constructor with an x and a y
    Vector2D(final float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    // Constructor with another vector2D
    Vector2D(final Vector2D vector)
    {
        set(vector.getX(), vector.getY());
    }
    // END CONSTRUCTORS
    //</editor-fold>


    //<editor-fold desc="ACCESSORS">
    // Returns X
    public float getX()
    {
        return x;
    }
    // Returns Y
    public float getY()
    {
        return y;
    }
    // END ACCESSORS
    //</editor-fold>


    //<editor-fold desc="MUTATORS">
    // Sets X
    public void setX(final float x)
    {
        this.x = x;
    }
    // Sets Y
    public void setY(final float y)
    {
        this.y = y;
    }
    // Sets X and Y
    public void set(final float x, final float y)
    {
        this.x = x;
        this.y = y;
    }
    // Sets X and Y using another vector2D
    public void set(final Vector2D vector)
    {
        this.x = vector.getX();
        this.y = vector.getY();
    }
    // END MUTATORS
    //</editor-fold>


    //<editor-fold desc="PUBLIC METHODS">
    // Adds a vector2D to another
    public void add(final Vector2D rhs)
    {
        this.setX(this.getX() + rhs.getX());
        this.setY(this.getY() + rhs.getY());
    }
    // Subtracts a vector2D from another
    public void subtract(final Vector2D rhs)
    {
        this.setX(this.getX() - rhs.getX());
        this.setY(this.getY() - rhs.getY());
    }
    // multiply a vector2D by another
    public void multiply(final Vector2D rhs)
    {
        this.setX(this.getX() * rhs.getX());
        this.setY(this.getY() * rhs.getY());
    }
    // divide a vector2D by another
    public void divide(final Vector2D rhs)
    {
        this.setX(this.getX() / rhs.getX());
        this.setY(this.getY() / rhs.getY());
    }

    // Checks if 2 vector2Ds are equal
    public boolean equals(final Vector2D rhs)
    {
        return ((this.getX() == rhs.getX()) && (this.getY() == rhs.getY()));
    }

    // Calculates and returns the magnitude
    public float getMagnitude()
    {
        return (float)(Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY()));
    }
    // Calculates and returns the squared magnitude
    public float getSqrtMagnitude()
    {
        return (float)(this.getX() * this.getX() + this.getY() * this.getY());
    }

    // Scales a vector2D with a float value
    public void setScale(final float scale)
    {
        this.set(this.getX() * scale, this.getY() * scale);
    }
    // Scales a vector2D with another vector2D
    public void setScale(final Vector2D scale)
    {
        this.set(this.getX() * scale.getX(), this.getY() * scale.getY());
    }

    // Normalizes a vector2D
    public void normalize()
    {
        var magnitude = this.getMagnitude();
        if ((double)(magnitude) > 9.99999974737875E-06)
        {
            set(getX() / magnitude, getY() / magnitude);
        }
        else
        {
            set(Vector2D.zero());
        }
    }
    // Returns a normalized vector2D
    public Vector2D getNormalized()
    {
        Vector2D vector = new Vector2D(getX(), getY());
        vector.normalize();
        return vector;
    }

    // Overrides toString to output a 2D point
    @Override
    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
    // END PUBLIC METHODS
    //</editor-fold>


    //<editor-fold desc="PRIVATE METHODS">

    // NOTHING RIGHT NOW

    // END PRIVATE METHODS
    //</editor-fold>


    //<editor-fold desc="STATIC METHODS">
    // Returns a vector2D == 0,0
    public static Vector2D zero()
    {
        return new Vector2D(0.0f, 0.0f);
    }
    // Returns a vector2D == 1,1
    public static Vector2D one()
    {
        return new Vector2D(1.0f, 1.0f);
    }

    // Returns a vector2D that's 1 left from the origin
    public static Vector2D left()
    {
        return new Vector2D(-1.0f, 0.0f);
    }
    // Returns a vector2D that's 1 right from the origin
    public static Vector2D right()
    {
        return new Vector2D(1.0f, 0.0f);
    }
    // Returns a vector2D that's 1 up from the origin
    public static Vector2D up()
    {
        return new Vector2D(0.0f, 1.0f);
    }
    // Returns a vector2D that's 1 down from the origin
    public static Vector2D down()
    {
        return new Vector2D(0.0f, -1.0f);
    }

    // Linear interpolation
    public static Vector2D lerp(final Vector2D a, final Vector2D b, float t)
    {
        // Clamp between 0.0 and 1.0
        if((double)(t) < 0.0)
        {
            t = 0.0f;
        }
        if((double)(t) > 1.0)
        {
            t = 1.0f;
        }
        return new Vector2D(a.getX() + (b.getX() - a.getX()) * t, a.getY() + (b.getY() - a.getY()) * t );
    }

    // Dot
    public static float dot(final Vector2D lhs, final Vector2D rhs)
    {
        return (float)((double)(lhs.getX()) * (double)(rhs.getX()) + (double)(lhs.getY()) * (double)(rhs.getY()));
    }

    // Returns distance
    public static float distance(final Vector2D a, final Vector2D b)
    {
        final var delta_x = (double)(b.getX()) - (double)(a.getX());
        final var delta_y = (double)(b.getY()) - (double)(a.getY());

        return (float)(Math.sqrt(delta_x * delta_x + delta_y * delta_y));
    }

    // END STATIC METHODS
    //</editor-fold>
}
