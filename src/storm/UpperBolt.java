package storm;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

/*
 * 将收到的原始商品名转换成大写再发送出去
 */
public class UpperBolt extends BaseBasicBolt {

	public void execute(Tuple input, BasicOutputCollector collector) {
		String src_word = input.getString(0);
		//转换成大写
		String upper_word = src_word.toUpperCase();
		collector.emit(new Values(new String[]{upper_word}));
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields(new String[]{"src_word"}));
	}

	

}
