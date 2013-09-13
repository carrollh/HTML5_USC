
public class Example {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// First, get the data from a sound file stored in .wav format.
		// Modify and use the following line if your .wav file is in a different folder
		// String fileName = "C:\\MyMusic\\iTunes\\BouncingSouls\\HopelessRomantic.wav";
		String fileName = "TokyoNena.wav";
		Sound sound1 = new Sound(fileName);
		
		// Next, print the sound to find out its length in samples
		System.out.println(sound1);
		
		// The following three lines get the value of a sound sample at
		// index 1000 and then set its value to half of the original. 
		int index = 1000;
		int value = sound1.getSampleValueAt(index);
		sound1.setSampleValueAt(index, value/2);
		
		// The following loop sets every sound sample to be twice its original value
		for (int n=0; n < sound1.getNumSamples(); n++) {
			value = sound1.getSampleValueAt(n);
			sound1.setSampleValueAt(n, value * 2);
		}

		// Listen to the sound
		sound1.play();
		sound1.write("NewSound.wav"); //save the processed file
	}

}
