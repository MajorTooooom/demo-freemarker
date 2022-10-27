# 数值类型
${number01}
${number02}

# 普通字符串
${number01?c}
${number02?c}

# 货币型字符串
${number01?string.currency}
#百分比类型字符串
${number02?string.percent}

# 指定小数位(小于实际位数时,将被裁剪)
${number01?string["0.#"]}
# 指定小数位(大于实际位数时,不会补零)
${number02?string["0.######"]}
