package Graphe;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JApplet;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxParallelEdgeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class JGraphXAdapterDemo
extends
JApplet
{
private static final long serialVersionUID = 2202072534703043194L;

private final Dimension DEFAULT_SIZE = new Dimension(530, 320);


/**
 * An alternative starting point for this demo, to also allow running this applet as an
 * application.
 *
 * @param args command line arguments
 */


public void init(int [][]m,int val,int...t)
{
    mxGraph graph = new mxGraph();
	Object parent = graph.getDefaultParent();
    int n=m[0][0];
    
    ArrayList<Object>h = new ArrayList<Object>();
    for(int i=1;i<=n;i++ )
    {
    	h.add(graph.insertVertex(parent, null, m[i][0], 20, 20, 30,30));
    }
    for(int i=1;i<=n;i++ )
    {
    	for(int j=1;j<=n;j++ )
        {
        
    		if(m[i][j]!=val && val==0)
    		{
    			graph.insertEdge(parent, null, "", h.get(i-1), h.get(j-1));
    		}
    		else
    		{
    			if(m[i][j]!=val)
        		{
        			graph.insertEdge(parent, null, m[i][j], h.get(i-1), h.get(j-1));
        		}	
    		}
        }
    }
    
    mxGraphComponent graphComponent = new mxGraphComponent(graph);
	getContentPane().add(graphComponent);
	mxCircleLayout layout = new mxCircleLayout(graph);
    int radius = 100;
    layout.setX0((DEFAULT_SIZE.width / 2.0) - radius);
    layout.setY0((DEFAULT_SIZE.height / 2.0) - radius);
    layout.setRadius(radius);
    layout.setMoveCircle(true);
    layout.execute(graph.getDefaultParent());
    if(t!=null)if(t[0]!=2)new mxParallelEdgeLayout(graph).execute(graph.getDefaultParent());
}
public void init(int [][]m)
{
	int val=100;
    mxGraph graph = new mxGraph();
	Object parent = graph.getDefaultParent();
    int n=m[0][0];
    
    ArrayList<Object>h = new ArrayList<Object>();
    for(int i=1;i<=n;i++ )
    {
    	System.out.println("g="+m[i][0]);
    	h.add(graph.insertVertex(parent, null, m[i][0], 20, 20, 30,30));
    }
    for(int i=1;i<=n;i++ )
    {
    	for(int j=1;j<=n;j++ )
        {
        
    		if(m[i][j]!=val && val==0)
    		{
    			graph.insertEdge(parent, null, "", h.get(i-1), h.get(j-1));
    		}
    		else
    		{
    			if(m[i][j]!=val)
        		{
        			graph.insertEdge(parent, null, m[i][j], h.get(i-1), h.get(j-1));
        		}	
    		}
        }
    }
    
    mxGraphComponent graphComponent = new mxGraphComponent(graph);
	getContentPane().add(graphComponent);
	mxCircleLayout layout = new mxCircleLayout(graph);
    int radius = 100;
    layout.setX0((DEFAULT_SIZE.width / 2.0) - radius);
    layout.setY0((DEFAULT_SIZE.height / 2.0) - radius);
    layout.setRadius(radius);
    layout.setMoveCircle(true);
    layout.execute(graph.getDefaultParent());
}
}