import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;

public class TestWindow {

	private JFrame frame;
	private JTextField processIDTextField;
	private JTextField priorityTextField;
	private final ArrayList readyQueue = new ArrayList();
    private Process1 runningProcess = null;
    private final ArrayList blockingQueue = new ArrayList();
    private int createdProcesses = 0;
    private int contextSwitches = 0;
    private JTextArea readyQueueTextArea ;
    private JTextArea blockingTextArea;
    private JTextArea runningTextArea ;
    private JTextArea systemStatusTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindow window = new TestWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 577, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JButton btnAddProcess = new JButton("Add process");
		btnAddProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProcessButtonActionPerformed(e);
			}
		});
		
		JLabel lblProcessId = new JLabel("Process ID:");
		
		processIDTextField = new JTextField();
		processIDTextField.setColumns(10);
		
		JLabel lblProcessPriority = new JLabel("Priority:");
		
		priorityTextField = new JTextField();
		priorityTextField.setColumns(10);
		
		JButton btnDeleteProcess = new JButton("Delete Process");
		btnDeleteProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteProcessButtonActionPerformed(e);
			}
		});
		
		JButton btnContextSwitching = new JButton("Context Switch");
		btnContextSwitching.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contextSwitchButtonActionPerformed(e);
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitButtonActionPerformed(e);
			}
			
		});
		
		JLabel lblReadyQueue = new JLabel("Ready Queue");
		
		JLabel lblRunningProcess = new JLabel("Running Process");
		
		JLabel lblBlockedProcess = new JLabel("Blocked Process");
		
		JLabel lblSystemStatus = new JLabel("System Status");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(lblReadyQueue)
					.addGap(119)
					.addComponent(lblRunningProcess)
					.addGap(96)
					.addComponent(lblBlockedProcess)
					.addContainerGap(22, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblProcessPriority, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(priorityTextField, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
									.addGap(84))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblProcessId)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(processIDTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addGap(49))))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
											.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
											.addGap(26)
											.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnDeleteProcess)
											.addGap(47)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(6)
													.addComponent(btnExit))
												.addComponent(btnContextSwitching))))
									.addContainerGap(12, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(6)
											.addComponent(lblSystemStatus))
										.addComponent(btnAddProcess))
									.addGap(241))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblReadyQueue)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblRunningProcess)
							.addComponent(lblBlockedProcess)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAddProcess)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblProcessId)
										.addComponent(processIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnDeleteProcess)
										.addComponent(btnContextSwitching))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblProcessPriority)
									.addComponent(priorityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnExit)
									.addGap(4)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSystemStatus)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		systemStatusTextArea = new JTextArea();
		systemStatusTextArea.setEditable(false);
		scrollPane_3.setViewportView(systemStatusTextArea);
		
		blockingTextArea = new JTextArea();
		blockingTextArea.setForeground(new Color(128, 128, 0));
		blockingTextArea.setEditable(false);
		scrollPane_2.setViewportView(blockingTextArea);
		
		runningTextArea = new JTextArea();
		runningTextArea.setForeground(new Color(0, 0, 255));
		runningTextArea.setEditable(false);
		scrollPane_1.setViewportView(runningTextArea);
		
		readyQueueTextArea = new JTextArea();
		readyQueueTextArea.setForeground(UIManager.getColor("Button.select"));
		readyQueueTextArea.setEditable(false);
		scrollPane.setViewportView(readyQueueTextArea);
		frame.getContentPane().setLayout(groupLayout);
	}
	private void addProcessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProcessButtonActionPerformed
	    
	    createdProcesses++;
	    int enteredPriority = Integer.parseInt(priorityTextField.getText());
	    if(enteredPriority <= 0){
	        enteredPriority = 1;
	    }
	    Process1 newProcess = new Process1(createdProcesses, enteredPriority);
	    boolean addedProcess = readyQueue.add(newProcess);
	    if (addedProcess){
	    	readyQueueTextArea.append("PNum: " + String.valueOf(newProcess.getProcessNumber()) + " | Priority: " + String.valueOf(enteredPriority) + "\n");
	    }
	    priorityTextField.setText("");
	    systemStatusTextArea.append("Added PNum: " + String.valueOf(createdProcesses) + " | Priority: " + String.valueOf(enteredPriority) + "\n");
	}
	private void deleteProcessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProcessButtonActionPerformed

	    int deletedProcess = Integer.parseInt(processIDTextField.getText());
	    if(runningProcess != null && runningProcess.getProcessNumber() == deletedProcess){
	        runningProcess = null;
	       runningTextArea.setText("");
	    } else{
	        boolean removed = removeFromReadyQueue(deletedProcess);
	        if(!removed){
	            removeFromBlockingQueue(deletedProcess);
	        }
	    }
	    processIDTextField.setText("");
	    systemStatusTextArea.append("Deleted PNum: " + String.valueOf(deletedProcess) + "\n");
	    	redrawReadyQueueTextArea();
	    	redrawBlockingTextArea();
	}
private boolean removeFromReadyQueue(int processID){
    
        
        for(Iterator<Process1> iterator = readyQueue.iterator(); iterator.hasNext();){
            Process1 currentProcess = iterator.next();
            if(currentProcess.getProcessNumber() == processID){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
private void removeFromBlockingQueue(int processID){
   
    
        for(Iterator<Process1> iterator = blockingQueue.iterator(); iterator.hasNext();){
            Process1 currentProcess = iterator.next();
            if(currentProcess.getProcessNumber() == processID){
                iterator.remove();
                break;
            }
        }
    }
private void redrawReadyQueueTextArea(){
    
        
        String readyProcesses = "";
        readyQueueTextArea.setText("");
        for(Iterator<Process1> iterator = readyQueue.iterator(); iterator.hasNext();){
            Process1 currentProcess = iterator.next();
            readyProcesses = readyProcesses.concat("PNum: " + String.valueOf(currentProcess.getProcessNumber()) + " | Priority: " + String.valueOf(currentProcess.getPriority()) + "\n");
        }
        readyQueueTextArea.setText(readyProcesses);
    }
private void redrawBlockingTextArea(){
  
        
        String blockingProcesses = "";
        blockingTextArea.setText("");
        for(Iterator<Process1> iterator = blockingQueue.iterator(); iterator.hasNext();){
            Process1 currentProcess = iterator.next();
            blockingProcesses = blockingProcesses.concat("PNum: " + String.valueOf(currentProcess.getProcessNumber()) + " | Priority: " + String.valueOf(currentProcess.getPriority()) + "\n");
        }
        blockingTextArea.setText(blockingProcesses);
    }
private void contextSwitchButtonActionPerformed(java.awt.event.ActionEvent evt) {
    
        if(runningProcess != null){
            runningProcess.doWork();
            if(runningProcess.getTimeToCompletion() == 0){
            	systemStatusTextArea.append("PNum " + runningProcess.getProcessNumber() + " completed.\n");
                runningProcess = null;
                runningTextArea.setText("");
            }
        }
        if(!readyQueue.isEmpty() || !blockingQueue.isEmpty()){
            updateQueues();
        }
        contextSwitches++;
        updateHistory(contextSwitches);
        redrawReadyQueueTextArea();
        redrawBlockingTextArea();
        
    }
private void updateQueues(){
    
    int highestPriority = 5000;
    Process1 newRunningProcess = runningProcess;
    if(runningProcess != null){
        highestPriority = runningProcess.getPriority();
    }
    for(Iterator<Process1> iterator = readyQueue.iterator(); iterator.hasNext();){
        Process1 currentProcess = iterator.next();
        int currentPriority = currentProcess.getPriority();
        if(currentPriority < highestPriority){
            newRunningProcess = currentProcess;
            highestPriority = currentPriority;
        }
    }
    for(Iterator<Process1> iterator = blockingQueue.iterator(); iterator.hasNext();){
        Process1 currentProcess = iterator.next();
        int currentPriority = currentProcess.getPriority();
        if((currentPriority < highestPriority)){
            newRunningProcess = currentProcess;
            highestPriority = currentPriority;
        }
    }
    if(runningProcess != null && newRunningProcess.getProcessNumber() != runningProcess.getProcessNumber()){
        blockingQueue.add(runningProcess);
        redrawBlockingTextArea();
        runningProcess = newRunningProcess;
        boolean removed = removeFromReadyQueue(newRunningProcess.getProcessNumber());
        if(!removed){
            removeFromBlockingQueue(newRunningProcess.getProcessNumber());
        }
    } else{
        boolean removed = removeFromReadyQueue(newRunningProcess.getProcessNumber());
        if(!removed){
            removeFromBlockingQueue(newRunningProcess.getProcessNumber());
        }
        runningProcess = newRunningProcess;
    }
    runningTextArea.setText("");
    runningTextArea.append("PNum:" + String.valueOf(runningProcess.getProcessNumber()) + " | Priority:" + String.valueOf(runningProcess.getPriority()) + "\n");
}

private void updateHistory(int contextSwitches){

	systemStatusTextArea.append("\n");
	systemStatusTextArea.append("System status after " + String.valueOf(contextSwitches) + " context switches.\n");
	systemStatusTextArea.append("Running Process:\n");
    if (runningProcess !=  null){
        systemStatusTextArea.append("PNum: " + String.valueOf(runningProcess.getProcessNumber()) + " | Priority: " + String.valueOf(runningProcess.getPriority()) + "\n");
    }
    systemStatusTextArea.append("\n");
    systemStatusTextArea.append("Ready Processes:\n");
    for(Iterator<Process1> iterator = readyQueue.iterator(); iterator.hasNext();){
        Process1 currentProcess = iterator.next();
        systemStatusTextArea.append("PNum: " + String.valueOf(currentProcess.getProcessNumber()) + " | Priority: " + String.valueOf(currentProcess.getPriority()) + "\n");
    }
    systemStatusTextArea.append("\n");
    systemStatusTextArea.append("Blocked Processes:\n");
    for(Iterator<Process1> iterator = blockingQueue.iterator(); iterator.hasNext();){
        Process1 currentProcess = iterator.next();
        systemStatusTextArea.append("PNum: " + String.valueOf(currentProcess.getProcessNumber()) + " | Priority: " + String.valueOf(currentProcess.getPriority()) + "\n");
    }
    systemStatusTextArea.append("\n");
}
private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
    
    System.exit(0);
}
}
