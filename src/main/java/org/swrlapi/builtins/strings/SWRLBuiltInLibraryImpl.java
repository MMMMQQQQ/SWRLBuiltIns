package org.swrlapi.builtins.strings;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.swrlapi.builtins.AbstractSWRLBuiltInLibrary;
import org.swrlapi.builtins.SWRLBuiltInLibraryManager;
import org.swrlapi.builtins.arguments.SWRLBuiltInArgument;
import org.swrlapi.exceptions.SWRLBuiltInException;
import org.swrlapi.ui.model.SWRLRulesAndSQWRLQueriesTableModel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
	

public class SWRLBuiltInLibraryImpl extends AbstractSWRLBuiltInLibrary  
{
	private static final String PREFIX = "strings";

	private static final String NAMESPACE = "http://swrl.stanford.edu/ontologies/built-ins/5.2.0/strings.owl#";
	 
	private static final String[] BUILT_IN_NAMES = { "stringEqual" };
	
	private static SWRLBuiltInLibraryManager swrlBuiltInLibraryManager;
	private static AbstractSWRLBuiltInLibrary abstractSWRLBuiltInLibrary;
	
	
	
	static {
		Method register = null;
		try {
			register = swrlBuiltInLibraryManager.getClass().getDeclaredMethod("registerSWRLBuiltIns", null);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		register.setAccessible(true);
		try {
			register.invoke(swrlBuiltInLibraryManager, PREFIX, NAMESPACE, new HashSet<>(Arrays.asList(BUILT_IN_NAMES)));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		swrlBuiltInLibraryManager.registerSWRLBuiltIns(PREFIX, NAMESPACE, new HashSet<>(Arrays.asList(BUILT_IN_NAMES)));
		
	}
	
	
  public SWRLBuiltInLibraryImpl()
  {
	  super(PREFIX, NAMESPACE, new HashSet<>(Arrays.asList(BUILT_IN_NAMES)));
    
  }
  
  @Override public void reset () { }
  
  public boolean stringEqual(@NonNull List<@NonNull SWRLBuiltInArgument> arguments) 
		   throws SWRLBuiltInException
		 {
		  final int argument1Number = 0, argument2Number = 1, numberOfArguments = 2;
		 
		  checkNumberOfArgumentsEqualTo(numberOfArguments, arguments.size());
		 
		  String argument1 = getArgumentAsAString(argument1Number, arguments);
		  String argument2 = getArgumentAsAString(argument2Number, arguments);
		 
		  return argument1.equalsIgnoreCase(argument2);
		 }
  }
