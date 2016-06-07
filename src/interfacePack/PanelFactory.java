package interfacePack;


public class PanelFactory {
	public Panel getPanel(String panelType){
		if(panelType == null){
	         return null;
	      }		
	      if(panelType.equalsIgnoreCase("OPTIONS")){
	         return new OptionsPanel();
	         
	      } else if(panelType.equalsIgnoreCase("QUESTIONS")){
	         return new QuestionsPanel();
	         
	      }	      
	      return null;
	}
}
