// The commands factory, it returns object from Open or Save Document class.

package commands;

public class CommandsFactory{

	public CommandsFactory() {
		
	}

	public ActionListener createCommand(String x) {
		switch(x){
			case "open": 
				return new OpenDocument();
			case "save":
				return new SaveDocument();
			case "documenttospeech":
				return new DocumentToSpeech();
			default: return null;
			}
	}
}