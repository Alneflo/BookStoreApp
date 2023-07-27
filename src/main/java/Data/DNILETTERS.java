package Data;

public enum DNILETTERS {
	T(0, 'T'),
	R(0, 'R'),
	W(0, 'W'),
	A(0, 'A'),
	G(0, 'G'),
	M(0, 'M'),
	Y(0, 'Y'),
	F(0, 'F'),
	P(0, 'P'),
	D(0, 'D'),
	X(0, 'X'),
	N(0, 'N'),
	J(0, 'J'),
	Z(0, 'Z'),
	S(0, 'S'),
	Q(0, 'Q'),
	V(0, 'V'),
	H(0, 'H'),
	L(0, 'L'),
	C(0, 'C'),
	K(0, 'K'),
	E(0, 'E');
	
	private int value;
	private char character;
	
	private DNILETTERS(int value, char character) {
		this.value = value;
		this.character = character;
	}
	
	public int getValue() {
		return value;
	}
	
	public char getCharacter() {
		return character;
	}
	
}
