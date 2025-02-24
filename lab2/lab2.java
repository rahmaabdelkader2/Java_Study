class Complex {
    private float real;
    private float imaginary;

    public Complex(float real, float imaginary) {
        this.real = real;     
        this.imaginary = imaginary;
    }

    public void setReal(float real) {
        this.real = real;
    }

    public void setImaginary(float imaginary) {
        this.imaginary = imaginary;
    }

    public float getReal() {
        return real;
    }

    public float getImaginary() {
        return imaginary;
    }

    public static Complex add(Complex c1, Complex c2) {
        Complex add_result = new Complex(c1.real + c2.real, c1.imaginary + c2.imaginary);
		return add_result;
    }

    public static Complex subtract(Complex c1, Complex c2) {
        Complex sub_result = new  Complex(c1.real - c2.real, c1.imaginary - c2.imaginary);
		return sub_result;
    }

 public void print() {
    if (imaginary >= 0)
        System.out.println(real + " + " + imaginary + "i");
    else
        System.out.println(real + " - " + (-imaginary) + "i");
}



    public static void main(String[] args) {
        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(1, 2);

        Complex sum = Complex.add(c1, c2);
        Complex diff = Complex.subtract(c2, c1);

        System.out.print("Sum: ");
        sum.print();

        System.out.print("Subtraction: ");
        diff.print();
    }
}
