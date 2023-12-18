import * as React from 'react';

import { StyleSheet, View, Text, Pressable } from 'react-native';
import { cancelTransaction, makeTransaction, reprinterTransaction } from 'react-native-stone-pos-deeplink';

export default function App() {

  const onMakeTransaction = () => {
    makeTransaction({      
      amount: "500",
      amountOfEditable: "0",
      installmentCount: "1",
      typeOfTransaction: "DEBIT", /* DEBIT, CREDIT, VOUCHER, INSTANT_PAYMENT e PIX */
      typeOfInstallment: "MERCHANT" /* MERCHANT (parcelado sem juros), ISSUER (parcelado com juros) e NONE (à vista) */
    })
  }

  const onReprinterTransaction = () => {
    reprinterTransaction({      
      showw_feedback_screen: "true",
      type_customer: 'MERCHANT', /* CLIENT (cliente), MERCHANT (lojista) */
      atk: "000000000000"
    })
  }

  const onCancelTransaction = () => {
    cancelTransaction({      
      editable_amount: "false",
      amount: "500",
      atk: "000000000000"
    })
  }

  return (
    <View style={styles.container}>

      <Pressable onPress={() => { onMakeTransaction() }}>
        <Text>Make Transaction</Text>
      </Pressable>

      <Pressable onPress={() => { onReprinterTransaction() }}>
        <Text>Reprinter Transaction</Text>
      </Pressable>
      
      <Pressable onPress={() => { onCancelTransaction() }}>
        <Text>Cancel Transaction</Text>
      </Pressable>

    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
