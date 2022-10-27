# 直接输出字符串
${strValue}

# 截取字符串,下标从0开始,左包右不包,超出长度会报错
${strValue?substring(0,1)}

# 首字母小写输出
${strValue?uncap_first}

# 首字母大写输出
${strValue?cap_first}

# 全部字母转小写
${strValue?lower_case}

# 全部字母转大写输出
${strValue?upper_case}

# 获取字符串长度
${strValue?length}

# 是否以指定字符开头(结果布尔值转字符串格式再输出)
${strValue?starts_with("A")?string}

# 是否以指定字符结尾(结果布尔值转字符串格式再输出)
${strValue?ends_with("A")?string}

# 获取某个字符在字符串中的索引位置(可以看出返回第一个匹配结果)
${strValue?index_of("C")}
${strValue?index_of("_")}

# 去除前后空格
输出结果:${strValue?trim}
输出结果的长度:${strValue?trim?length}

# 替换字符串
${strValue?replace("Bb","中国")}
