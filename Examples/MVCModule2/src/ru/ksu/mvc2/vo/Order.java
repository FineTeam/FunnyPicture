package ru.ksu.mvc2.vo;

import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.LinkedHashMap;

/**
 * @author alexander.shlyannikov
 *         24.11.11 12:22
 */
public class Order implements Serializable, JSONStreamAware {
    private long id;
    private String address;

    public Order(long id, String address) {
        this.id = id;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void writeJSONString(Writer out) throws IOException {
        LinkedHashMap obj = new LinkedHashMap();
        obj.put("id", id);
        obj.put("address", address);
        JSONValue.writeJSONString(obj, out);
    }
}
