package pr0304Barracks.core;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Runnable;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.core.commands.AddCommand;
import pr0304Barracks.core.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;
	private static final String COMMAND_CLASS_NAME = "pr0304Barracks.core.commands.";

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

		final String className = COMMAND_CLASS_NAME + Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1) + "Command";

		Class commandClass = Class.forName(className);
		Constructor<?> commandCTOR = commandClass.getDeclaredConstructors()[0];
		commandCTOR.setAccessible(true);
		Command command = (Command)commandCTOR.newInstance(data, repository, unitFactory);
		String result = command.execute();


		//		String result;
//		switch (commandName) {
//			case "add":
//				result = this.addUnitCommand(data);
//				break;
//			case "report":
//				result = this.reportCommand(data);
//				break;
//			case "fight":
//				result = this.fightCommand(data);
//				break;
//			default:
//				throw new RuntimeException("Invalid command!");
//		}
//		return result;

		return result;
	}

//	private String reportCommand(String[] data) {
//		String output = this.repository.getStatistics();
//		return output;
//	}

//	private String addUnitCommand(String[] data) throws ExecutionControl.NotImplementedException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
//		String unitType = data[1];
//		Unit unitToAdd = this.unitFactory.createUnit(unitType);
//		this.repository.addUnit(unitToAdd);
//		String output = unitType + " added!";
//		return output;
//	}
	
//	private String fightCommand(String[] data) {
//		return "fight";
//	}
}
