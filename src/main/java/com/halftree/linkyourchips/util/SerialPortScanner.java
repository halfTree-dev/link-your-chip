package com.halftree.linkyourchips.util;

import com.fazecast.jSerialComm.SerialPort;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import java.util.ArrayList;
import java.util.List;

public class SerialPortScanner {

    public static class PortInfo {
        public final String portName;
        public final String description;
        public final String location;

        public PortInfo(SerialPort port) {
            this.portName = port.getSystemPortName();
            this.description = port.getPortDescription();
            this.location = port.getPortLocation();
        }

        public String getDisplayString() {
            StringBuilder sb = new StringBuilder();
            sb.append(portName);
            if (description != null && !description.isEmpty()) {
                sb.append(" - ").append(description);
            }
            return sb.toString();
        }
    }

    public static List<PortInfo> scanAvailableSerialPorts() {
        List<PortInfo> portList = new ArrayList<>();
        try {
            SerialPort[] ports = SerialPort.getCommPorts();
            for (SerialPort port : ports) {
                portList.add(new PortInfo(port));
            }
        } catch (Exception e) {
            System.err.println("Error occured in SerialPortScanner: " + e.getMessage());
        }
        return portList;
    }

    public static SerialPort getPortByName(String portName) {
        SerialPort[] ports = SerialPort.getCommPorts();
        for (SerialPort port : ports) {
            if (port.getSystemPortName().equals(portName)) {
                return port;
            }
        }
        return null;
    }

    public static void sendPortInfoToChat(Minecraft minecraft) {
        if (minecraft.player == null) return;

        List<PortInfo> portList = scanAvailableSerialPorts();
        minecraft.player.sendSystemMessage(Component.literal("§a===== 串口扫描结果 ====="));

        if (portList.isEmpty()) {
            minecraft.player.sendSystemMessage(Component.literal("§c未发现串口设备"));
        } else {
            minecraft.player.sendSystemMessage(Component.literal("§e发现 " + portList.size() + " 个串口设备:"));
            for (int i = 0; i < portList.size(); i++) {
                PortInfo info = portList.get(i);
                minecraft.player.sendSystemMessage(Component.literal("§b" + (i + 1) + ". " + info.getDisplayString()));
            }
        }

        minecraft.player.sendSystemMessage(Component.literal("§a======================="));
    }
}
