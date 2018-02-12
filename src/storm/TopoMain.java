package storm;

import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.topology.IBasicBolt;
import org.apache.storm.topology.IRichSpout;
import org.apache.storm.topology.TopologyBuilder;



/**
 * 描述topology的结构,以及创建topology并提交给集群
 * @author Administrator
 *
 */
public class TopoMain {

	public static void main(String[] args) throws AlreadyAliveException, InvalidTopologyException, AuthorizationException {
		IRichSpout randomSpot =new RandomSpot();
		Integer num =new Integer(4);
		IBasicBolt upperbolt = new UpperBolt();
		IBasicBolt suffixbolt = new SuffixBolt();
		TopologyBuilder topologyBuilder =new TopologyBuilder();
		//设置消息源组件为RandomSpout
		topologyBuilder.setSpout("randomspout",randomSpot,num);
		//设置逻辑处理组件UpperBolt,并指定接收randomspolt的消息
		topologyBuilder.setBolt("upperbolt", upperbolt, num).shuffleGrouping("randomspout");
		//设置逻辑处理组件Suffixbolt,并指定接收upperbolt的消息
		topologyBuilder.setBolt("upperbolt", suffixbolt, num).shuffleGrouping("upperbolt");
		//创建一个topology
		StormTopology topo= topologyBuilder.createTopology();
		//创建一个storm的配置参数对象
		Config conf = new Config();
			//设置进程数
		conf.setNumWorkers(4);
		conf.setDebug(true);
		conf.setNumAckers(0);
		//提交到topo到storm集群 
		StormSubmitter.submitTopology("demo", conf, topo);
	}

}
