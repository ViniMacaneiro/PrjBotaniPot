#include <Arduino.h>
#include <WiFiMulti.h>
#include <WiFi.h>
#define WIFI_SSID "Redmi Note 11"
#define WIFI_PASSWORD "seubobao"

WiFiMulti wifiMulti;

void setup() {
  Serial.begin(9600);
  pinMode(LED_BUILTIN, OUTPUT);
  // wifiMulti.addAP(WIFI_SSID, WIFI_PASSWORD);
  // while (wifiMulti.run() != WL_CONNECTED)
  // {
  //   delay(100);
  // }
  
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Startando");
}

void loop() {
  // if(WiFi.isConnected()){
  // digitalWrite(LED_BUILTIN, LOW);
  // } else{
  // digitalWrite(LED_BUILTIN, HIGH);

  if(WiFi.isConnected()){
    Serial.print("Conectou");
    digitalWrite(LED_BUILTIN, LOW);
  } else{
    Serial.print(".");
    digitalWrite(LED_BUILTIN, !digitalRead(LED_BUILTIN));
    delay(1000);
  }

}