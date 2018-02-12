package storm;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;

/**
 * 给商品名称添加后缀,然后将数据写入文件中
 * @author Administrator
 *
 */
public class SuffixBolt extends BaseBasicBolt {
	FileWriter fileWriter=null;
	
	public void prepare(Map stormConf, TopologyContext context) {
		try {
			fileWriter = new FileWriter("/home/hadoop/"+UUID.randomUUID());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void execute(Tuple input, BasicOutputCollector collector) {
		String upper_word = input.getString(0);
		String result = upper_word +"_suffix";
		
		try {
			fileWriter = new FileWriter("/home/hadoop/");
			fileWriter.append(result);
			fileWriter.append("\n");
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields(new String[]{"src_word"}));
	}



}
