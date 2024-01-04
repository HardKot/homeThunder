import {Box, MenuItem, Paper, Typography} from "@mui/material";
import {CSelectFieldForm, CTextFieldForm, CDateFieldForm} from "@/src/shared/forms";
import {useFormContext} from "react-hook-form";

const RegistrationFormPersonalData = ({  }) => {
  const { control } = useFormContext()
  return (
    <Paper className={"p-3 flex m-3 flex-col"}>
      <Typography variant="subtitle1">Личные данные</Typography>
      <Box className={"flex lg:flex-row flex-col"}>
        <Box
          className={"flex flex-col space-y-2.5"}
        >
          <CTextFieldForm
            name={"firstname"}
            control={control}
            rules={{required: true}}
            label={"Имя"}
          />
          <CTextFieldForm
            name={"lastname"}
            control={control}
            rules={{required: true}}
            label={"Фамилия"}
          />
          <CTextFieldForm
            name={"patronymic"}
            control={control}
            label={"Отчество"}
          />
        </Box>

        <Box className={"flex flex-col space-y-2.5 lg:my-0 my-3 lg:ml-3 ml-0"}>
          <CSelectFieldForm
            label={"Пол"}
            name={"gender"}
            control={control}
          >
            <MenuItem value={"female"}>Женский</MenuItem>
            <MenuItem value={"male"}>Мужской</MenuItem>
          </CSelectFieldForm>
          <CDateFieldForm
            label={"Дата рождения"}
            name={"birthday"}
            control={control}
          />
        </Box>
      </Box>
    </Paper>
  )
}


export default RegistrationFormPersonalData
