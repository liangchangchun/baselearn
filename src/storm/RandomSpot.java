package storm;

import java.util.Map;
import java.util.Random;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

public class RandomSpot extends BaseRichSpout{

	String[] goods = {"iphone","xiaomi","meizu","zhongxing"};
	SpoutOutputCollector collector = null;
	public void nextTuple() {
		//随机取到一个商品名称
		Random random = new Random();
		String good = goods[random.nextInt(goods.length)];
		//封装到tuple中发送出去
		collector.emit(new Values(new String[]{good}));
	}

	//进行初始化,只在开始的时候调用一次
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		this.collector =collector;
		
	}

	/**
	 * 定义tuple的scheme
	 */
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		
		declarer.declare(new Fields(new String[]{"src_word"}));
	}

}
