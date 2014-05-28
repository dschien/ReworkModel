package rework;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoLink<T> extends BaseLink<T>	{

	/**
	 * Returns an agentset of workers on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of workers on patch p
	 */
	@ReLogoBuilderGeneratedFor("rework.relogo.Worker")
	public AgentSet<rework.relogo.Worker> workersOn(Patch p){
		AgentSet<rework.relogo.Worker> result = new AgentSet<rework.relogo.Worker>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"worker")){
			if (t instanceof rework.relogo.Worker)
			result.add((rework.relogo.Worker)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of workers on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of workers on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("rework.relogo.Worker")
	public AgentSet<rework.relogo.Worker> workersOn(Turtle t){
		AgentSet<rework.relogo.Worker> result = new AgentSet<rework.relogo.Worker>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"worker")){
			if (tt instanceof rework.relogo.Worker)
			result.add((rework.relogo.Worker)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of workers on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of workers on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("rework.relogo.Worker")
	public AgentSet<rework.relogo.Worker> workersOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<rework.relogo.Worker>();
		}

		Set<rework.relogo.Worker> total = new HashSet<rework.relogo.Worker>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(workersOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(workersOn(p));
				}
			}
		}
		return new AgentSet<rework.relogo.Worker>(total);
	}

	/**
	 * Queries if object is a worker.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a worker
	 */
	@ReLogoBuilderGeneratedFor("rework.relogo.Worker")
	public boolean isWorkerQ(Object o){
		return (o instanceof rework.relogo.Worker);
	}

	/**
	 * Returns the worker with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("rework.relogo.Worker")
	public rework.relogo.Worker worker(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof rework.relogo.Worker)
			return (rework.relogo.Worker) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all workers.
	 * 
	 * @return agentset of all workers
	 */
	@ReLogoBuilderGeneratedFor("rework.relogo.Worker")
	public AgentSet<rework.relogo.Worker> workers(){
		AgentSet<rework.relogo.Worker> a = new AgentSet<rework.relogo.Worker>();
		for (Object e : this.getMyObserver().getContext().getObjects(rework.relogo.Worker.class)) {
			if (e instanceof rework.relogo.Worker){
				a.add((rework.relogo.Worker)e);
			}
		}
		return a;
	}

	/**
	 * Queries if object is a userLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userLink
	 */
	@ReLogoBuilderGeneratedFor("rework.relogo.UserLink")
	public boolean isUserLinkQ(Object o){
		return (o instanceof rework.relogo.UserLink);
	}

	/**
	 * Returns an agentset containing all userLinks.
	 * 
	 * @return agentset of all userLinks
	 */
	@ReLogoBuilderGeneratedFor("rework.relogo.UserLink")
	public AgentSet<rework.relogo.UserLink> userLinks(){
		AgentSet<rework.relogo.UserLink> a = new AgentSet<rework.relogo.UserLink>();
		for (Object e : this.getMyObserver().getContext().getObjects(rework.relogo.UserLink.class)) {
			if (e instanceof rework.relogo.UserLink){
				a.add((rework.relogo.UserLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("rework.relogo.UserLink")
	public rework.relogo.UserLink userLink(Number oneEnd, Number otherEnd) {
		return (rework.relogo.UserLink)(this.getMyObserver().getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("rework.relogo.UserLink")
	public rework.relogo.UserLink userLink(Turtle oneEnd, Turtle otherEnd) {
		return userLink(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Returns the value of the global variable reworkRate.
	 *
	 * @return the value of the global variable reworkRate
	 */
	@ReLogoBuilderGeneratedFor("global: reworkRate")
	public Object getReworkRate(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("reworkRate");
	}

	/**
	 * Sets the value of the global variable reworkRate.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: reworkRate")
	public void setReworkRate(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("reworkRate",value);
	}

	/**
	 * Returns the value of the global variable numWorkers.
	 *
	 * @return the value of the global variable numWorkers
	 */
	@ReLogoBuilderGeneratedFor("global: numWorkers")
	public Object getNumWorkers(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("numWorkers");
	}

	/**
	 * Sets the value of the global variable numWorkers.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: numWorkers")
	public void setNumWorkers(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("numWorkers",value);
	}

	/**
	 * Returns the value of the global variable numJobs.
	 *
	 * @return the value of the global variable numJobs
	 */
	@ReLogoBuilderGeneratedFor("global: numJobs")
	public Object getNumJobs(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("numJobs");
	}

	/**
	 * Sets the value of the global variable numJobs.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: numJobs")
	public void setNumJobs(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("numJobs",value);
	}


}