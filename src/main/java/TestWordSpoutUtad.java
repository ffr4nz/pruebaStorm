import backtype.storm.Config;
import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.utils.Utils;
import backtype.storm.tuple.Values;
import backtype.storm.tuple.Fields;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class TestWordSpoutUtad  extends BaseRichSpout {
    boolean _isDistributed;
    SpoutOutputCollector _collector;

    public TestWordSpoutUtad() {
        this(true);
    }

    public TestWordSpoutUtad(boolean isDistributed) {
        _isDistributed = isDistributed;
    }

    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        _collector = collector;
    }

    public void close() {

    }

    public void nextTuple() {
        /*********************************************************************************
         *
         * Poner aquí la implementación de lo que queremos hacer con la siguiente tupla
         *
         *********************************************************************************/
    }

    public void ack(Object msgId) {

    }

    public void fail(Object msgId) {

    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("word"));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        if(!_isDistributed) {
            Map<String, Object> ret = new HashMap<String, Object>();
            ret.put(Config.TOPOLOGY_MAX_TASK_PARALLELISM, 1);
            return ret;
        } else {
            return null;
        }
    }
}