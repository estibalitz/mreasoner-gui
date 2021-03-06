package edu.casetools.mreasoner.gui.core.view.panels.options.Configs.General;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;

import edu.casetools.mreasoner.gui.utils.SpringUtilities;
import edu.casetools.mreasoner.configurations.data.MConfigurations;


public class FilePathsPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	//JPanel mainPanel;
	JLabel specificationLabel,resultsLabel,LFPUBSLabel,configsLabel;
	JLabel specificationPathLabel,resultsPathLabel,LFPUBSPathLabel,configsPathLabel;
	JButton specificationButton,resultsButton,LFPUBSLabelButton,ConfigsLabelButton;
	
	
	
	public FilePathsPanel(MConfigurations configs){
		 //mainPanel = new JPanel(new SpringLayout());
		this.setLayout(new SpringLayout());
		 TitledBorder titledBorder = BorderFactory.createTitledBorder("File Paths Configurations");
		 //mainPanel.setBorder(titledBorder);
		 this.setBorder(titledBorder);
		 specificationLabel = new JLabel("System Specification File Path");
		 resultsLabel = new JLabel("System Results File Path");
		 LFPUBSLabel = new JLabel("LFPUBS Output File Path");
		 configsLabel = new JLabel("System Configurations File Path");
		 
		 specificationPathLabel = new JLabel(writeNull(configs.getSystemSpecificationFilePath()));
		 specificationPathLabel.setForeground(Color.LIGHT_GRAY);
		 resultsPathLabel = new JLabel(writeNull(configs.getResultsFilePath()));
		 resultsPathLabel.setForeground(Color.LIGHT_GRAY);
		 LFPUBSPathLabel = new JLabel(writeNull(configs.getLFPUBSOutputFilePath()));
		 LFPUBSPathLabel.setForeground(Color.LIGHT_GRAY);
		 configsPathLabel = new JLabel(writeNull(configs.getSessionFilePath()));
		 configsPathLabel.setForeground(Color.LIGHT_GRAY);
		 

	        
	     this.add( specificationLabel );
	     this.add( specificationPathLabel );
	     this.add(	resultsLabel );   
	     this.add( resultsPathLabel );
	     this.add( LFPUBSLabel );
	     this.add( LFPUBSPathLabel );
	     this.add(	configsLabel );   
	   	 this.add( configsPathLabel );
	   	 
        SpringUtilities.makeCompactGrid(this,
                8, 1, 		  //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
	 //  	 mainPanel.add(this);
		 
	}
	
	public String writeNull(String line){
		if((line != null)&&(!line.equals("null"))){
			return line;
		}else return "Path not assigned.";
	}
	
	public String readNull(String line){
		if((line != null)&&(!line.equals("Path not assigned."))){
			return line;
		}else return "null";
	}

	public MConfigurations getPathConfigs(MConfigurations configs) {
		configs.setSystemSpecificationFilePath(readNull(specificationPathLabel.getText()));
		configs.setResultsFilePath(readNull(resultsPathLabel.getText()));
		configs.setLFPUBSOutputFilePath(readNull(LFPUBSPathLabel.getText()));
		configs.setSessionFilePath(readNull(configsPathLabel.getText()));
		return configs;
	}
	
	public void setPathConfigs(MConfigurations configs) {
		specificationPathLabel.setText(writeNull(configs.getSystemSpecificationFilePath()));
		resultsPathLabel.setText(writeNull(configs.getResultsFilePath()));
		LFPUBSPathLabel.setText(writeNull(configs.getLFPUBSOutputFilePath()));
		configsPathLabel.setText(writeNull(configs.getSessionFilePath()));
	}
	
	public String getSystemDeclarationFilePath(){
		return readNull(specificationPathLabel.getText());
	}
	
	public String getResultsPath(){
		return readNull(resultsPathLabel.getText());
	}
	
	public String getLFPUBSPath(){
		return readNull(LFPUBSPathLabel.getText());
	}
	
	public String getConfigsPath(){
		return readNull(configsPathLabel.getText());
	}
	
	public void setSystemDeclarationFilePath(String path){
		specificationPathLabel.setText(writeNull(path));
	}
	
	public void setResultsPath(String path){
		resultsPathLabel.setText(writeNull(path));
	}
	
	public void setLFPUBSPath(String path){
		LFPUBSPathLabel.setText(writeNull(path));
	}
	
	public void setConfigsPath(String path){
		configsPathLabel.setText(writeNull(path));
	}
	
}
