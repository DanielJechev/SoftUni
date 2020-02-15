package pr0304Barracks.contracts;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

	String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, ExecutionControl.NotImplementedException, IllegalAccessException;

}
