package org.elsys.gates;

public abstract class NandFactory {

	public static Gate makeNotGate(Wire in, Wire out, String name) {
		NandGate object = new NandGate(in, in, out, name);
		return object;
	}

	public static Gate makeNotGate(Wire in, Wire out) {
		return makeNotGate(in, out, "NandNot");
	}

	public static Gate makeAndGate(Wire in1, Wire in2, Wire out, String name) {
		Wire jica = new Wire("jica");
		NandGate object = new NandGate(in1, in2, jica, name);
		NandGate object1 = new NandGate(jica, jica, out, name);
		CompositeGate Andgate = new CompositeGate("Andgate");
		Andgate.addGate(object);
		Andgate.addInput(in1);
		Andgate.addInput(in2);
		Andgate.addInput(out);
		Andgate.addGate(object1);

		return Andgate;
	}

	public static Gate makeAndGate(Wire in1, Wire in2, Wire out) {
		return makeAndGate(in1, in2, out, "NandAnd");
	}

	public static Gate makeOrGate(Wire in1, Wire in2, Wire out, String name) {
		
		
		Wire jica1 = new Wire("jica1");
		Wire jica2 = new Wire("jica2");
		
		CompositeGate OrGate = new CompositeGate("OrGate");

		NandGate object1 = new NandGate(in1, in1, jica1, name);
		NandGate object2 = new NandGate(in2, in2, jica2, name);
		NandGate object3 = new NandGate(jica1, jica2, out, name);
		
		OrGate.addGate(object1);
		OrGate.addGate(object2);
		OrGate.addGate(object3);
		OrGate.addInput(in1);
		OrGate.addInput(in2);
		OrGate.addInput(out);
		
		return OrGate;
	}

	public static Gate makeOrGate(Wire in1, Wire in2, Wire out) {
		return makeOrGate(in1, in2, out, "NandOr");
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out, String name) {
		
		Wire jica1 = new Wire("jica1");
		Wire jica2 = new Wire("jica2");
		Wire jica3 = new Wire("jica3");
		
		CompositeGate NOR = new CompositeGate("OrGate");

		NandGate object1 = new NandGate(in1, in1, jica1, name);
		NandGate object2 = new NandGate(in2, in2, jica2, name);
		NandGate object3 = new NandGate(jica1, jica2, jica3, name);
		NandGate object4 = new NandGate(jica3, jica3, out, name);

		NOR.addGate(object1);
		NOR.addGate(object2);
		NOR.addGate(object3);
		NOR.addGate(object4);
		NOR.addInput(in1);
		NOR.addInput(in2);
		NOR.addOutput(out);
		
		return NOR;
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out) {
		return makeXorGate(in1, in2, out, "NandXor");
	}

}
