package com.youfan.sink;

import com.youfan.liuLiang.log.app.Diveceanaly;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DiveceanalySink implements SinkFunction<Diveceanaly> {

    @Override
    public void invoke(Diveceanaly value, Context context) throws Exception {
        Map data = ObjectToMapUtils.transferToMap(value);
        Set<String> intField = new HashSet<String>();
        data.remove("groupField");
        intField.add("pv");
        intField.add("uv");
        intField.add("productnums");
        DorisDbUtils.insertdata("Diveceanaly",data,intField);
    }
}
