# Grus Japonenis ���˵��

��ǩ���ո�ָ����� MVVM RXJAVA LINT DEAGGER2

---

## 1,Lint
    Android Lint��Google�ṩ��Android�����ߵľ�̬�����鹤�ߡ�ʹ��Lint��Android���̴������ɨ��ͼ�飬���Է��ִ���Ǳ�ڵ����⣬���ѳ���Ա����������

### 1��ԭʼ���Զ���Lint����λ�� **lib.lintrules** Ŀ¼������һ��Java��Ŀ��

 1. Detector�ฺ��ɨ����룬�������Ⲣ���棻
 2. Issue����Detector���ֲ����棬��Android���������ܴ��ڵ�bug��
 3. Category��ָ����������
 4. IssueRegistry���ṩ��Ҫ������Issue�б�

��projectĿ¼��ִ�� **gradlew lib.lintrules:assemble**��windows���� **./gradlew lib.lintrules:assemble**��Linux����� ����jar�ļ��� **lib.lintrules/build/libs/lib.lintrules.jar**·����


### 2��**lib.lintrules-jar**��Android Library��Ŀ������jar�ļ�����aar�ļ���

��projectĿ¼��ִ�� **gradlew lib.lintrules-jar:assemble**��windows���� **./gradlew lib.lintrules-jar:assemble**��Linux����� ����aar�ļ��� **lib.lintrules/build/outputs/aar/lib.lintrules-jar-release.aar**·����

### 3��**lib.lintrules-aar**�ǵ���aar�⣬����module���������

���������ɵ�aar�ļ����Ƶ� **lib.lintrules-aar/lib.lintrules-jar-release.aar**·����

```JAVA
dependencies {
    ...
    compile project(':lib.lintrules-aar')
    ...
}
```



