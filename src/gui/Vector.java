package gui;

/**
 * This is a single vector used to assist rendering, its made up of three values being x,y and z
 */
public class Vector {
    double x, y, z;

    public Vector(double x, double y, double z) {
        double Length = Math.sqrt(x * x + y * y + z * z);

        if (Length > 0) {
            this.x = x / Length;
            this.y = y / Length;
            this.z = z / Length;
        }
    }

    /**
     * Return the cross product of this vector and vector v
     * @param V
     * @return
     */
    public Vector CrossProduct(Vector V) {
        Vector CrossVector = new Vector(
                y * V.z - z * V.y,
                z * V.x - x * V.z,
                x * V.y - y * V.x);
        return CrossVector;
    }
}
