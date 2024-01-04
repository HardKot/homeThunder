import {Box, Paper, Typography} from "@mui/material";
import {CTextFieldForm} from "@/src/shared/forms";
import {useFormContext} from "react-hook-form";

const RegistrationFormContactInformation = ({  }) => {
  const { control } = useFormContext()
  return (
    <Paper className={"p-3 flex m-3 flex-col h-42"}>
      <Typography variant="subtitle1">Контактная информация</Typography>
        <Box
          className={"flex flex-col space-y-2.5"}
        >
          <CTextFieldForm
            name={"phone"}
            control={control}
            rules={{ pattern: /^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$/i }}
            label={"Номер телефона"}
          />
          <CTextFieldForm
            name={"email"}
            control={control}
            rules={{ pattern: /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/ }}
            label={"Электронная почта"}
          />
        </Box>
    </Paper>
  )
}


export default RegistrationFormContactInformation
