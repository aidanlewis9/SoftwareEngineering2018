package model.infrastructure;

import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.infrastructure.gate.CrossingGate;

/**
 * Creates all infrastructure for the simulation
 * @author jane
 *
 */
public class MapBuilder {
	HashMap<String, Road> roads;
	HashMap<String, CrossingGate> gates;
	HashMap<String, RailwayTracks> tracks;
	
	public MapBuilder(){
		roads = new HashMap<String,Road>();
		gates = new HashMap<String,CrossingGate>();
		tracks = new HashMap<String,RailwayTracks>();
		buildRoads();
		configureIntersections();
		buildCrossingGates();
		buildTracks();
		assignGatesToRoads();
	}

	private void buildRoads() {
		roads.put("Western Highway North", new Road(new Point(800,0),new Point (800,700), Direction.SOUTH,true,false));
		roads.put("Western Highway South", new Road(new Point(800,700),new Point (800,1000), Direction.SOUTH,false,false));
		roads.put("Skyway North", new Road(new Point(400,0),new Point (400,700),Direction.SOUTH,true,false));
		roads.put("Skyway South", new Road(new Point(400,700),new Point (400,1000),Direction.SOUTH,false,false));
		roads.put("EastWest", new Road(new Point(415,700),new Point (785,700),Direction.WEST,false,true));
	}

	private void configureIntersections() {
		roads.get("Western Highway North").addIntersection(roads.get("Western Highway South"));
		roads.get("Skyway North").addIntersection(roads.get("Skyway South"));
		roads.get("Western Highway North").addIntersection(roads.get("EastWest"));
		roads.get("EastWest").addIntersection(roads.get("Skyway South"));
	}
	
	private void buildCrossingGates(){
		gates.put("Gate1", new CrossingGate(780,480, "Gate1"));
		gates.put("Gate2", new CrossingGate(380,480, "Gate2"));
	}
	
	private void buildTracks(){
		tracks.put("Royal", new RailwayTracks(new Point(0,500),new Point(1200,500)));
		tracks.put("Regal", new RailwayTracks(new Point(0, 550), new Point(1200, 550)));
	}
	
	private void assignGatesToRoads(){
		roads.get("Western Highway North").assignGate(gates.get("Gate1"));
		roads.get("Skyway North").assignGate(gates.get("Gate2"));
	}
	
	public Collection<CrossingGate> getAllGates(){
		return gates.values();
	}
	
	public Collection<RailwayTracks> getTracks(){
		return tracks.values();
	}
	
	public Collection<Road> getRoads(){
		return roads.values();
	}
	
	public RailwayTracks getTrack(String name){
		return tracks.get(name);
	}
}
